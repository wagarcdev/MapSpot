package com.arcieri.wagner.mapspot.presentation

import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.MapProperties

data class MapState(
    val properties: MapProperties = MapProperties(),
    val isNoLabelsMap: Boolean = false
) {

}
