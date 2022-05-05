package com.example.wishes.ui.main

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.wishes.databinding.FragmentMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment : BasicFragmentWithBottomMenu<FragmentMainBinding>() {

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentMainBinding {
          return  FragmentMainBinding.inflate(inflater, container, false)
    }

    override fun inflateBottomNavigationView(): BottomNavigationView {
        Log.d("s", "ssssssssssssssssssssssssssssss 2222 ")
        return binding.bottomMenu.bottomNavigation
    }

}