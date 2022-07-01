package com.arcieri.wagner.mapspot.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MapSpotEntity::class], version = 1)
abstract class MapSpotDatabase: RoomDatabase() {

    abstract val dao: MapsSpotDAO

}