package com.example.bitfit_v1_android_app

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDao {
    @Insert
    suspend fun insert(entry: FoodEntry)

    @Query("SELECT * FROM food_table ORDER BY id DESC")
    fun getAllEntries(): Flow<List<FoodEntry>>
}
