package com.arcieri.wagner.mapspot.data

import com.arcieri.wagner.mapspot.domain.model.MapSpot

fun MapSpotEntity.toMapSpot(): MapSpot {
    return MapSpot(
        lat = lat,
        lng = lng,
        id = id

    )
}

fun MapSpot.toMapSpotEntity(): MapSpotEntity {
    return MapSpotEntity(
        lat = lat,
        lng = lng,
        id = id
    )
}