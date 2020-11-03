package com.example.cocktailhour.misc

import android.content.Context
import android.os.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Chronometer
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cocktailhour.R
import com.example.cocktailhour.ui.shoppinglist.ShoppingListViewModel

class TimerFragment : Fragment() {

    private lateinit var shoppingListViewModel: ShoppingListViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        shoppingListViewModel =
                ViewModelProviders.of(this).get(ShoppingListViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_timer, container, false)
        val textView: TextView = root.findViewById(R.id.text_timer)
        shoppingListViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        val timerBtn = root.findViewById<Button>(R.id.timerBtn)
        val viewTimer: Chronometer = root.findViewById<Chronometer>(R.id.view_timer)
        viewTimer.text = "00:15"

        timerBtn.setOnClickListener {
            viewTimer.isCountDown = true
            viewTimer.base = SystemClock.elapsedRealtime() + 15000
            viewTimer.start()
        }

        viewTimer.setOnChronometerTickListener {
            if (it.text.toString() == "00:00") {

                Handler(Looper.getMainLooper()).postDelayed({
                    // Reset Chronometer
                    it.onChronometerTickListener = null
                    it.stop()

                    viewTimer.base = SystemClock.elapsedRealtime() + 15000
                    val vibrator = context?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                    vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE))
                }, 1000)
            }
        }

        return root
    }
}