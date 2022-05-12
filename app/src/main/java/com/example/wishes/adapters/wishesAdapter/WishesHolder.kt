package com.example.wishes.adapters.wishesAdapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.wishes.R
import com.example.wishes.models.Wish
import com.example.wishes.ui.fragments.main.detailFragments.WishDetailFragment

class WishesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var img = itemView.findViewById<ImageView>(R.id.card_wish_img)
    private var title = itemView.findViewById<TextView>(R.id.card_wish_title)
    private lateinit var wish: Wish

    fun bind(wish: Wish) {
        this.wish = wish
        title.text = wish.title

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
            nav.navigate(R.id.action_mainFragment_to_wishDetailFragment, bundleOf(WishDetailFragment.ID_WISH to  wish.id))
        }
    }
}