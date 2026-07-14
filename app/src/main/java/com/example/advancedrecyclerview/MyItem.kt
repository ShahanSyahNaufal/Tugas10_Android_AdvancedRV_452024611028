package com.example.advancedrecyclerview

data class MyItem(val id: Long, val name: String, val value: Int, val color: Int)

sealed class DataItem {
    abstract val id: Long

    data class Content(val item: MyItem) : DataItem() {
        override val id = item.id
    }

    object Header : DataItem() {
        override val id = Long.MIN_VALUE
    }
}
