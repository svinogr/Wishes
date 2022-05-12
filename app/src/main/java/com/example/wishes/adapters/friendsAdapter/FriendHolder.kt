package com.example.wishes.adapters.friendsAdapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.wishes.R
import com.example.wishes.models.Friend
import com.example.wishes.ui.fragments.main.detailFragments.FriendDetailFragment
import com.example.wishes.ui.fragments.main.detailFragments.WishDetailFragment

class FriendHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val img = itemView.findViewById<ImageView>(R.id.card_friend_img)
    private val nameFriend = itemView.findViewById<TextView>(R.id.card_friend_name)
    private val birthday = itemView.findViewById<TextView>(R.id.card_friend_birthday)
    private lateinit var friend: Friend

    fun bind(friend: Friend) {
        this.friend = friend
        nameFriend.text = friend.name
        birthday.text = friend.birthday.toString()

        val transformation = MultiTransformation(CenterCrop(), RoundedCorners(16))
        Glide.with(itemView)
            //.load(RetrofitInst.IMG_SHOP_URL + shop.img)
            .load(R.mipmap.ic_launcher)
            .transform(transformation)
            .placeholder(R.drawable.ic_baseline_exit_to_app_24).into(img)

        setClickListener()
    }

    private fun setClickListener() {
        itemView.setOnClickListener {
            val nav = Navigation.findNavController(itemView)
            // val bundle = bundleOf(WishDetailFragment.ID_WISH to  wish.id)
            nav.navigate(R.id.action_friendsFragment_to_friendDetailFragment, bundleOf(FriendDetailFragment.ID_FRIEND to  friend.id))
        }
    }
}