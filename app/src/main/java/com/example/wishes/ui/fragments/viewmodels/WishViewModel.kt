package com.example.wishes.ui.fragments.viewmodels

import android.util.MutableDouble
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wishes.models.Wish
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class WishViewModel: ViewModel() {
    private val _listWishes =  MutableLiveData<List<Wish>>()
    val listWishes: LiveData<List<Wish>> = _listWishes

    fun getWishesByUserId(id: Int) {
        GlobalScope.launch(Dispatchers.IO) {
            val wishes = testWishe()
            _listWishes.postValue(wishes)
        }
    }




    fun testWishe(): List<Wish> {
        val list = mutableListOf<Wish>()
        for (i in 1..10) {
            val wish = Wish(i, i.toString(), 1)
            list.add(wish)
        }
        return list
    }
}