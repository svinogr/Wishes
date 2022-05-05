package com.example.wishes.adapters.wishesAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wishes.R
import com.example.wishes.models.Wish

class WishesAdapter(val list: List<Wish> = mutableListOf()) : RecyclerView.Adapter<WishesHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishesHolder {
        val inflateView = LayoutInflater.from(parent.context).inflate(R.layout.card_wish, parent, false)
         return WishesHolder(inflateView)
    }

    override fun onBindViewHolder(holder: WishesHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}