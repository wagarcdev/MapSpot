package com.arcieri.wagner.mapspot.presentation

import com.arcieri.wagner.mapspot.domain.model.MapSpot
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.MapProperties

data class MapState(
    val properties: MapProperties = MapProperties(),
    val isNoLabelsMap: Boolean = false,
    val mapSpots: List<MapSpot> = emptyList()
) {

}
