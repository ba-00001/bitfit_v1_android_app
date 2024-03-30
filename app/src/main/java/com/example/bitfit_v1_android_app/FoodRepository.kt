package com.example.bitfit_v1_android_app

class FoodRepository(private val foodDao: FoodDao) {
    val allEntries = foodDao.getAllEntries()

    suspend fun insert(entry: FoodEntry) {
        foodDao.insert(entry)
    }
}
