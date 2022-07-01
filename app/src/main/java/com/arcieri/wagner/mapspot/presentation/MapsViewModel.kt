package com.arcieri.wagner.mapspot.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arcieri.wagner.mapspot.domain.model.MapSpot
import com.arcieri.wagner.mapspot.domain.repository.MapSpotRepository
import com.google.android.gms.maps.model.MapStyleOptions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(
    private val repository: MapSpotRepository
) : ViewModel() {

    var state by mutableStateOf(MapState())

    init {
        viewModelScope.launch {
            repository.getMapSpots().collectLatest { spots ->
                state = state.copy(
                    mapSpots = spots
                )
            }
        }
    }

    fun onEvent(event: MapEvent) {
        when(event) {
            is MapEvent.ToggleNoLabelsMap -> {
                state = state.copy(
                    properties = state.properties.copy(
                        mapStyleOptions =
                            if (state.isNoLabelsMap) {
                                null
                            } else {
                                MapStyleOptions(MapStyle.noLabelMapJson)
                            }
                    ),
                    isNoLabelsMap = !state.isNoLabelsMap
                )

            }

            is MapEvent.OnMapLongClick -> {
                viewModelScope.launch {
                    repository.insertMapSpot(
                        MapSpot(
                            lat = event.latLng.latitude,
                            lng = event.latLng.longitude
                        )
                    )
                }
            }

            is MapEvent.OnInfoWindowLongClick -> {
                viewModelScope.launch {
                    repository.deleteMapSpot(event.spot)
                }
            }

        }
    }
}