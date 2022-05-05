package com.example.wishes.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wishes.databinding.FragmentFriendsBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

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
        print("ddeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeewdwdwd")
        return binding.bottomMenu.bottomNavigation
    }

}