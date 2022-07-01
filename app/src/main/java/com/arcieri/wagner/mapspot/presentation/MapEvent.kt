package com.arcieri.wagner.mapspot.presentation

import com.arcieri.wagner.mapspot.domain.model.MapSpot
import com.google.android.gms.maps.model.LatLng

sealed class MapEvent {
    object ToggleNoLabelsMap: MapEvent()
    data class OnMapLongClick(val latLng: LatLng): MapEvent()
    data class OnInfoWindowLongClick(val spot: MapSpot): MapEvent()
}
