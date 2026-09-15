package edu.temple.inclassuiactivity

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)

        /* Step 1: Populate this array */
        val numberArray = Array(50){i -> (i + 1) * 2}

        with (spinner) {
            /* Step 2: Create adapter to display items from array in Spinner */
            //adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_item, numberArray)
            adapter = TextSizeAdapter(this@MainActivity, numberArray)

            // Step 3: Change TextView's text size to the number selected in the Spinner */
            onItemSelectedListener = object : OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    parent?.run {
                        displayTextView.textSize = getItemAtPosition(position).toString().toFloat()
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

            }
        }

    }
}