package com.example.bitfit_v1_android_app

import androidx.lifecycle.*

class FoodViewModel(private val repository: FoodRepository) : ViewModel() {
    val allEntries: LiveData<List<FoodEntry>> = repository.allEntries.asLiveData()

    fun insert(entry: FoodEntry) = viewModelScope.launch {
        repository.insert(entry)
    }
}

class FoodViewModelFactory(private val repository: FoodRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FoodViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FoodViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
