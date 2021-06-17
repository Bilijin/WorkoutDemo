package com.mobolajialabi.workoutdemo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WorkoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout)

        intent.getStringExtra("name")?.let {
            val txt : TextView = findViewById(R.id.name)
            txt.text = it
        }

//        if (intent.getStringExtra("name") != null) {
//            val txt : TextView = findViewById(R.id.name)
//            txt.text = intent.getStringExtra("name")
//        }
    }
}