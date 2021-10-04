package com.example.indra.data.network.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.indra.data.model.MovieEntity
import com.example.indra.domain.usecase.response.MovieResponse

@Dao
interface MovieDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: MovieResponse): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(movies: List<MovieResponse>)

    @Query("SELECT * FROM TableMovie")
    fun loadListMovieAll(): MutableList<MovieResponse>
}