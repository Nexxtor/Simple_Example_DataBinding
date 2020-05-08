package com.naldana.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil

import com.naldana.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var inCounter = Counter("In", 0)
    var outCounter = Counter("Out", 0)

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Restablecer valores previos

        binding.apply {
            inCounter = this@MainActivity.inCounter
            outCounter = this@MainActivity.outCounter

            buttonAddIn.setOnClickListener {
                this@MainActivity.inCounter.count++
                invalidateAll()
            }

            buttonAddOut.setOnClickListener {
                this@MainActivity.outCounter.count++
                invalidateAll()
            }
        }
    }


}
