package com.example.wishes.ui.fragments.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wishes.adapters.wishesAdapter.WishesAdapter
import com.example.wishes.databinding.FragmentMainBinding
import com.example.wishes.models.Wish
import com.example.wishes.ui.fragments.viewmodels.WishViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class WishFragment : BasicFragmentWithBottomMenu<FragmentMainBinding>() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: WishesAdapter
    private lateinit var wishObserver: Observer<List<Wish>>

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMainBinding {
        return FragmentMainBinding.inflate(inflater, container, false)
    }

    override fun inflateBottomNavigationView(): BottomNavigationView {
        return binding.bottomMenu.bottomNavigation
    }

    override fun setViews() {
        setRecyclerView()
        setViewModel()

    }

    private fun setViewModel() {
        val viewModel = ViewModelProvider(this)[WishViewModel::class.java]
        wishObserver = Observer {
            adapter.list = it
            adapter.notifyDataSetChanged()
        }

        viewModel.listWishes.observe(viewLifecycleOwner, wishObserver)
        viewModel.getWishesByUserId(1)
    }

    private fun setRecyclerView() {
        adapter = WishesAdapter()

        recyclerView = binding.mainFragmentRecView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }
}