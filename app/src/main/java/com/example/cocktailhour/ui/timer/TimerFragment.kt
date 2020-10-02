package com.example.cocktailhour.ui.timer

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

class TimerFragment : Fragment() {

    private lateinit var timerViewModel: TimerViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        timerViewModel =
                ViewModelProviders.of(this).get(TimerViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_timer, container, false)
        val textView: TextView = root.findViewById(R.id.text_timer)
        timerViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        val timerBtn = root.findViewById<Button>(R.id.timerBtn)
        val view_timer = root.findViewById<Chronometer>(R.id.view_timer)
        view_timer.text = "00:15"

        timerBtn.setOnClickListener {
            view_timer.isCountDown = true
            view_timer.base = SystemClock.elapsedRealtime() + 15000
            view_timer.start()
        }

        view_timer.setOnChronometerTickListener {
            if (it.text.toString().equals("00:00")) {

                Handler(Looper.getMainLooper()).postDelayed({
                    // Reset Chronometer
                    it.onChronometerTickListener = null
                    it.stop()

                    view_timer.base = SystemClock.elapsedRealtime() + 15000
                    val vibrator = context?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                    vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE))
                }, 1000)
            }
        }

        return root
    }
}