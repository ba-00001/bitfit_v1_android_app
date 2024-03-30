package com.example.bitfit_v1_android_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

// MainActivity.kt - Main activity for the BitFit app
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: FoodViewModel
    private lateinit var foodAdapter: FoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView and set its adapter
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        foodAdapter = FoodAdapter(emptyList())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = foodAdapter

        // Set up ViewModel and observe changes to the food entries
        val repository = FoodRepository(AppDatabase.getDatabase(this).foodDao())
        val viewModelFactory = FoodViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[FoodViewModel::class.java]
        viewModel.allEntries.observe(this) { entries ->
            entries?.let {
                foodAdapter.updateData(it)
            }
        }

        // Floating Action Button to add new food entries
        val fab: FloatingActionButton = findViewById(R.id.addNewFoodButton)
        fab.setOnClickListener {
            // This should start an activity where you can add new food entries
            val intent = Intent(this, AddFoodEntryActivity::class.java)
            startActivity(intent)
        }
    }
}
