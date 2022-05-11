package com.example.wishes.adapters.friendsAdapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.wishes.R
import com.example.wishes.models.Friend

class FriendHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val img = itemView.findViewById<ImageView>(R.id.card_friend_img)
    private val nameFriend = itemView.findViewById<TextView>(R.id.card_friend_name)
    private val birthday = itemView.findViewById<TextView>(R.id.card_friend_birthday)

    fun bind(friend: Friend) {
        nameFriend.text = friend.name
        birthday.text = friend.birthday.toString()

        val transformation = MultiTransformation(CenterCrop(), RoundedCorners(16))
        Glide.with(itemView)
            //.load(RetrofitInst.IMG_SHOP_URL + shop.img)
            .load(R.mipmap.ic_launcher)
            .transform(transformation)
            .placeholder(R.drawable.ic_baseline_exit_to_app_24).into(img)
    }
}