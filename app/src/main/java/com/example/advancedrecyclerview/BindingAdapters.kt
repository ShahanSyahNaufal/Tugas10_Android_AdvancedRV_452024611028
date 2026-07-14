package com.example.advancedrecyclerview

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("itemColor")
fun setItemColor(view: View, color: Int) {
    view.setBackgroundColor(color)
}

@BindingAdapter("valueFormatted")
fun setValueFormatted(view: TextView, value: Int) {
    view.text = "Value: $value"
}
