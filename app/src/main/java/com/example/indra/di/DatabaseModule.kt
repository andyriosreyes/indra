package com.example.indra.di

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import com.example.indra.data.network.local.DataBase
import com.example.indra.data.network.local.MovieDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    internal fun provideAppDatabase(application: Application): DataBase {
        return Room.databaseBuilder(
            application,
            DataBase::class.java,
            DataBase.DB_NAME
        ).allowMainThreadQueries().build()
    }


    @Provides
    internal fun provideArticleDao(appDatabase: DataBase): MovieDAO {
        return appDatabase.movieDAO
    }
}