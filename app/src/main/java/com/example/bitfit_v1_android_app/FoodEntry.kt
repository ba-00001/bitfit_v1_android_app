package com.example.bitfit_v1_android_app

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food_table")
data class FoodEntry(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val foodName: String,
    val calories: Int
)
