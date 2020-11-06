package com.example.cocktailhour.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cocktailhour.misc.MapActivity
import com.example.cocktailhour.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)


        val mapImageView: ImageView = root.findViewById(R.id.mapImageView)

        mapImageView.setOnClickListener {
            val intent = Intent(this.context, MapActivity::class.java)
            startActivity(intent)
        }
        
        return root
    }
}