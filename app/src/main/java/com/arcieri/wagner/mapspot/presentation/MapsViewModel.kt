package com.arcieri.wagner.mapspot.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.MapStyleOptions

class MapsViewModel: ViewModel() {
    var state by mutableStateOf(MapState())

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
        }
    }
}