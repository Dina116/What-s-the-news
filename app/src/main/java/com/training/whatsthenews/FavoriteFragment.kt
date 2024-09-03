package com.training.whatsthenews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.training.whatsthenews.databinding.FragmentFavoriteBinding
import com.training.whatsthenews.databinding.FragmentHomeBinding


class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Initialize binding first
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Now you can safely access binding.root to find the Toolbar
        val toolbar = binding.root.findViewById<Toolbar>(R.id.app_tool_bar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(false) // Disable default title
        val title = toolbar.findViewById<TextView>(R.id.toolbar_title)
        title.text = "Favorites"

    }
}
