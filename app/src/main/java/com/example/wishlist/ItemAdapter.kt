package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter (private val itemsList: List<Item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemTextView: TextView
        var costTextView: TextView
        var urlTextView: TextView

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            itemTextView = itemView.findViewById(R.id.item_name)
            costTextView = itemView.findViewById(R.id.item_cost)
            urlTextView = itemView.findViewById(R.id.item_url)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.wishlist_layout, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = itemsList.get(position)
        holder.itemTextView.text = items.itemName
        holder.costTextView.text = items.cost.toString()
        holder.urlTextView.text = items.url
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

}