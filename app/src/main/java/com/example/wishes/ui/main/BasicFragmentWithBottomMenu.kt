package com.example.wishes.ui.main

import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.example.wishes.R
import com.google.android.material.bottomnavigation.BottomNavigationView

// чтобы не было стрелки от фрагменнта назад нужно в мейнактивити добавить фрагмент в дрювер
abstract class BasicFragmentWithBottomMenu<VB: ViewBinding> : Fragment() {
    private  var _binding: VB? = null
    val binding get() = _binding!!
    private lateinit var bottomMenu: BottomNavigationView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflateBinding(inflater, container)

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
        return binding.root
    }

    abstract fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): VB
    abstract fun inflateBottomNavigationView(): BottomNavigationView

}