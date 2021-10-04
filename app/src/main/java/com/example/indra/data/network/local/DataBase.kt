package com.example.indra.data.network.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.indra.data.model.MovieEntity
import com.example.indra.domain.usecase.response.MovieResponse

@Database(entities = [MovieResponse::class], version = 1, exportSchema = false)
abstract class DataBase()  : RoomDatabase() {
    abstract val movieDAO: MovieDAO

    companion object {
        const val DB_NAME = "INDRA.db"
    }
}
