package com.arcieri.wagner.mapspot.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MapSpotEntity(
    val lat: Double,
    val lng: Double,

    @PrimaryKey
    val id: Int? = null


)
