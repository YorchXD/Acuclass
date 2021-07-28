package com.example.acuclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.acuclass.databinding.ActivityMainBinding
import com.example.acuclass.view.Fragments.MenuFragment

class MainActivity : AppCompatActivity()
{
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.contenedorFragments,MenuFragment()).commit()
    }
}