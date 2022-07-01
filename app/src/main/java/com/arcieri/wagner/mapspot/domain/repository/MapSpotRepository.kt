package com.arcieri.wagner.mapspot.domain.repository

import com.arcieri.wagner.mapspot.domain.model.MapSpot
import kotlinx.coroutines.flow.Flow

interface MapSpotRepository {

    suspend fun insertMapSpot(spot: MapSpot)

    suspend fun deleteMapSpot(spot: MapSpot)

    fun getMapSpots(): Flow<List<MapSpot>>

}