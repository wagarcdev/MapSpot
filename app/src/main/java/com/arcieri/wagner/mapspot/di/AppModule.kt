package com.arcieri.wagner.mapspot.di

import android.app.Application
import androidx.room.Room
import com.arcieri.wagner.mapspot.data.MapSpotDatabase
import com.arcieri.wagner.mapspot.data.MapSpotRepositoryImplementation
import com.arcieri.wagner.mapspot.domain.repository.MapSpotRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMapSpotDatabase(app: Application): MapSpotDatabase {
        return Room.databaseBuilder(
            app,
            MapSpotDatabase::class.java,
            "map_spots.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideMapSpotRepository(db: MapSpotDatabase): MapSpotRepository{
        return MapSpotRepositoryImplementation(db.dao)
    }
}