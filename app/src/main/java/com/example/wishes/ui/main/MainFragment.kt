package com.example.wishes.ui.main

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wishes.adapters.wishesAdapter.WishesAdapter
import com.example.wishes.databinding.FragmentMainBinding
import com.example.wishes.models.Wish
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment : BasicFragmentWithBottomMenu<FragmentMainBinding>() {

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentMainBinding {
          return  FragmentMainBinding.inflate(inflater, container, false)
    }

    override fun inflateBottomNavigationView(): BottomNavigationView {
        return binding.bottomMenu.bottomNavigation
    }

    override fun setRecyclerView(): RecyclerView {
        val mainFragmentRecView = binding.mainFragmentRecView

        val adapter = WishesAdapter(testWishe())
        mainFragmentRecView.layoutManager =LinearLayoutManager(requireContext())
        mainFragmentRecView.adapter = adapter

        return mainFragmentRecView
    }

    fun testWishe(): List<Wish> {
        val list = mutableListOf<Wish>()
        for (i in 1..10) {
            val wish = Wish(i, i.toString())
            list.add(wish)
        }
        return list
    }

}