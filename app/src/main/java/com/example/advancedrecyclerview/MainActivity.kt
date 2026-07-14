package com.example.advancedrecyclerview

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.advancedrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val adapter = MyAdapter()
        binding.recyclerView.adapter = adapter

        val manager = GridLayoutManager(this, 3)
        manager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (adapter.getItemViewType(position)) {
                    0 -> 3 // Header takes full width (3 spans)
                    else -> 1 // Items take 1 span
                }
            }
        }
        binding.recyclerView.layoutManager = manager

        val items = listOf(
            DataItem.Header,
            DataItem.Content(MyItem(1, "Item 1", 100, Color.parseColor("#FFCDD2"))),
            DataItem.Content(MyItem(2, "Item 2", 200, Color.parseColor("#F8BBD0"))),
            DataItem.Content(MyItem(3, "Item 3", 300, Color.parseColor("#E1BEE7"))),
            DataItem.Content(MyItem(4, "Item 4", 400, Color.parseColor("#D1C4E9"))),
            DataItem.Content(MyItem(5, "Item 5", 500, Color.parseColor("#C5CAE9"))),
            DataItem.Content(MyItem(6, "Item 6", 600, Color.parseColor("#BBDEFB")))
        )
        adapter.submitList(items)
    }
}
