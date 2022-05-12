package com.example.wishes.ui.fragments.main.detailFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wishes.R
import com.example.wishes.adapters.wishesAdapter.WishesAdapter
import com.example.wishes.databinding.FragmentFriendDetailBinding
import com.example.wishes.models.Wish

class FriendDetailFragment : BasicDetailFragment<FragmentFriendDetailBinding>() {
    private var id: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getInt(ID_FRIEND)
        }
    }

    companion object {
        const val ID_FRIEND = "id"
    }

    override fun setViews() {
        setTestText()
        setRecyclerView()
    }

    private fun setTestText() {
        binding.friendDetailTitle.text = "SEMENOVNA"
        binding.friendDetailBirthday.text = "11.11.2002"
    }

    private fun setRecyclerView() {
        val recycler = binding.friendDetailRecView
        val adapter = WishesAdapter(testWishe())
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter
    }

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFriendDetailBinding? {
        return FragmentFriendDetailBinding.inflate(inflater, container, false)
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