package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var items: MutableList<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items = ItemFetcher.getItem()

        val button = findViewById<Button>(R.id.button)
        val item = findViewById<EditText>(R.id.name)
        val cost = findViewById<EditText>(R.id.cost)
        val url = findViewById<EditText>(R.id.url)

        button.setOnClickListener {
            val itemEntry = Item(item.text.toString(), cost.text.toString().toDouble(), url.text.toString())
            items.add(itemEntry)

            val adapter = ItemAdapter(items)
            val itemRV = findViewById<RecyclerView>(R.id.itemsRv)
            itemRV.adapter = adapter
            itemRV.layoutManager = LinearLayoutManager(this)

            item.text.clear()
            cost.text.clear()
            url.text.clear()
        }
    }
}