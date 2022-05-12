package com.example.wishes.ui.fragments.main.detailFragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.wishes.databinding.FragmentWishDetailBinding

class WishDetailFragment : BasicDetailFragment<FragmentWishDetailBinding>() {
    private var id: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getInt(ID_WISH)
        }
    }

    companion object {
        const val ID_WISH = "id"
    }

    override fun setViews() {
        //TODO livedata
    }

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentWishDetailBinding? {
        return FragmentWishDetailBinding.inflate(inflater, container, false)
    }
}