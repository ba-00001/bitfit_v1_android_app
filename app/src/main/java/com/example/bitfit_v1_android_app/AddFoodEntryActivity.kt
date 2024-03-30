package com.example.bitfit_v1_android_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.bitfit_v1_android_app.databinding.ActivityAddFoodEntryBinding

class AddFoodEntryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddFoodEntryBinding
    private lateinit var viewModel: FoodViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddFoodEntryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModelFactory = FoodViewModelFactory((application as BitFitApplication).repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(FoodViewModel::class.java)

        binding.addButton.setOnClickListener {
            val foodName = binding.foodNameEditText.text.toString()
            val calories = binding.caloriesEditText.text.toString().toIntOrNull() ?: 0
            val foodEntry = FoodEntry(foodName = foodName, calories = calories)
            viewModel.insert(foodEntry)
            finish()
        }
    }
}
