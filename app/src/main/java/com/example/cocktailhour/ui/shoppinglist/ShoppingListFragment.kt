package com.example.cocktailhour.ui.shoppinglist

import android.os.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cocktailhour.R

class ShoppingListFragment : Fragment() {

    private lateinit var shoppingListViewModel: ShoppingListViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        shoppingListViewModel =
                ViewModelProviders.of(this).get(ShoppingListViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_shopping, container, false)

/*        val textView: TextView = root.findViewById(R.id.text_timer)
        shoppingListViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/

/*        val timerBtn = root.findViewById<Button>(R.id.timerBtn)

        timerBtn.setOnClickListener {
            viewTimer.isCountDown = true
            viewTimer.base = SystemClock.elapsedRealtime() + 15000
            viewTimer.start()
        }*/

        return root
    }
}