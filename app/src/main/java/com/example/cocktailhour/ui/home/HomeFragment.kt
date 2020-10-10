package com.example.cocktailhour.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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
        val textView: TextView = root.findViewById(R.id.text_home)


        val mapBtn: Button = root.findViewById(R.id.mapBtn)

        mapBtn.setOnClickListener {
            val intent = Intent(this.context, MapActivity::class.java)
            startActivity(intent)
        }

        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it


        })
        return root
    }
}