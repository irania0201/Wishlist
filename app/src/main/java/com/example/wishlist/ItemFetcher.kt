package com.example.wishlist

class ItemFetcher {
    companion object {
        var itemsList = mutableListOf<Item>()

        fun addItem(itemName: String, cost: Double, url: String) {
            val item = Item(itemName, cost, url)
            itemsList.add(item)
        }

        fun getItem(): MutableList<Item> {
            return itemsList
        }
    }
}