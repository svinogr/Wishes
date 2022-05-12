package com.example.wishes.ui.fragments.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.wishes.R
import com.google.android.material.bottomnavigation.BottomNavigationView

// чтобы не было стрелки от фрагменнта назад нужно в мейнактивити добавить фрагмент в дрювер
abstract class BasicFragmentWithBottomMenu<VB: ViewBinding> : Fragment() {
    private  var _binding: VB? = null
    val binding get() = _binding!!
    private lateinit var bottomMenu: BottomNavigationView
    open val recyclerView: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateBinding(inflater, container)

        setBottomMenu()
        setRecyclerView()

        return binding.root
    }

    private fun setBottomMenu() {
        bottomMenu = inflateBottomNavigationView()
        bottomMenu.setOnItemSelectedListener {item ->
            when(item.itemId){
                R.id.wishes -> {

                    findNavController().navigate(R.id.mainFragment)
                    true
                }
                R.id.friends -> {
                    findNavController().navigate(R.id.friendsFragment)
                    true
                }
                else -> false
            }
        }
    }

    abstract fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): VB
    abstract fun inflateBottomNavigationView(): BottomNavigationView
    abstract fun setRecyclerView(): RecyclerView
}