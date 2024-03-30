package com.example.bitfit_v1_android_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bitfit_v1_android_app.databinding.ItemFoodBinding

class FoodAdapter(private var entries: List<FoodEntry>) : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate the item layout using View Binding
        val binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entry = entries[position]
        holder.bind(entry)
    }

    override fun getItemCount(): Int = entries.size

    class ViewHolder(private val binding: ItemFoodBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(entry: FoodEntry) {
            binding.foodNameText.text = entry.foodName
            binding.caloriesText.text = "${entry.calories} Calories"
        }
    }

    fun updateData(newEntries: List<FoodEntry>) {
        entries = newEntries
        notifyDataSetChanged()
    }
}
