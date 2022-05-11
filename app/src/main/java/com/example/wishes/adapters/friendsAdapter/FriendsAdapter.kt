package com.example.wishes.adapters.friendsAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wishes.R
import com.example.wishes.models.Friend

class FriendsAdapter(val list: List<Friend> = mutableListOf()) :
    RecyclerView.Adapter<FriendHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendHolder {
        val inflateView =
            LayoutInflater.from(parent.context).inflate(R.layout.card_friend, parent, false)
        return FriendHolder(inflateView)
    }

    override fun onBindViewHolder(holder: FriendHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}