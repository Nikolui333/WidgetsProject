package com.example.widgetsproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.example.widgetsproject.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.content, Shop()).commit()

        binding?.bottomNav?.setOnItemSelectedListener { item ->

            when (item.itemId) {
                R.id.baselineMenuBottomNav -> supportFragmentManager.beginTransaction()
                    .replace(R.id.content, BaselineMenu()).commit()
                R.id.shopItemBottomNav -> supportFragmentManager.beginTransaction()
                    .replace(R.id.content, Shop()).commit()
                R.id.deliveryItemBottomNav -> supportFragmentManager.beginTransaction()
                    .replace(R.id.content, Delivery()).commit()
                R.id.accountItemBottomNav -> supportFragmentManager.beginTransaction()
                    .replace(R.id.content, Account()).commit()
            }

            return@setOnItemSelectedListener true

        }
        binding?.bottomNav?.selectedItemId = R.id.shopItemBottomNav
    }
}