package com.example.wishes.ui.fragments.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wishes.adapters.friendsAdapter.FriendsAdapter
import com.example.wishes.databinding.FragmentFriendsBinding
import com.example.wishes.models.Friend
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class FriendsFragment : BasicFragmentWithBottomMenu<FragmentFriendsBinding>() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFriendsBinding {
        return FragmentFriendsBinding.inflate(inflater, container, false)
    }

    override fun inflateBottomNavigationView(): BottomNavigationView {
        return binding.bottomMenu.bottomNavigation
    }

    override fun setRecyclerView(): RecyclerView {
        val mainFragmentRecView = binding.friendFragmentRecView

        val adapter = FriendsAdapter(testFriend())
        mainFragmentRecView.layoutManager = LinearLayoutManager(requireContext())
        mainFragmentRecView.adapter = adapter

        return mainFragmentRecView
    }

    private fun testFriend(): List<Friend> {
        val list = mutableListOf<Friend>()
        for (i in 1..10) {
            val wish = Friend(i, "name ${i}", Date())
            list.add(wish)
        }
        return list
    }

}