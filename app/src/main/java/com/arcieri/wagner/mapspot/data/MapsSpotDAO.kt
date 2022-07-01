package com.arcieri.wagner.mapspot.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MapsSpotDAO {

    @Insert(onConflict = REPLACE)
    suspend fun insertMapSpot(spot: MapSpotEntity)

    @Delete
    suspend fun deleteMapSpot(spot: MapSpotEntity)

    @Query("SELECT * FROM mapspotentity")
    fun getSpots(): Flow<List<MapSpotEntity>>
}