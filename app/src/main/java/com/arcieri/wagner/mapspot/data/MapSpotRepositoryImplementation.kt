package com.arcieri.wagner.mapspot.data

import com.arcieri.wagner.mapspot.domain.model.MapSpot
import com.arcieri.wagner.mapspot.domain.repository.MapSpotRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MapSpotRepositoryImplementation(
    private val dao: MapsSpotDAO
): MapSpotRepository {

    override suspend fun insertMapSpot(spot: MapSpot) {
        dao.insertMapSpot(spot.toMapSpotEntity())
    }

    override suspend fun deleteMapSpot(spot: MapSpot) {
        dao.deleteMapSpot(spot.toMapSpotEntity())
    }

    override fun getMapSpots(): Flow<List<MapSpot>> {
        return dao.getSpots().map { spotsEntities ->
            spotsEntities.map { it.toMapSpot() }
        }
    }
}