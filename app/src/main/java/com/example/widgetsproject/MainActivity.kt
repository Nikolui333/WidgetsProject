package com.example.widgetsproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.example.widgetsproject.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setSupportActionBar(binding?.topAppBar)

        binding?.topAppBar?.setOnMenuItemClickListener { menuItem:MenuItem ->

            when(menuItem.itemId) {

                R.id.folderItemTopNav -> {
                    supportFragmentManager.beginTransaction().replace(R.id.content, Folder()).commit()

                    true

                }

                R.id.settingsItemTopNav -> {
                    supportFragmentManager.beginTransaction().replace(R.id.content, Settings()).commit()

                    true

                }

                else -> false
            }

        }

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

        setSupportActionBar(binding?.topAppBar)
        binding?.topAppBar?.setOnMenuItemClickListener { menuItem -> itemSelected(menuItem)}
    }

    private fun itemSelected(item: MenuItem):Boolean {

        when(item.itemId) {

            R.id.shopItemBottomNav ->  supportFragmentManager.beginTransaction().replace(R.id.content,
                Shop()
            ).commit()

            R.id.deliveryItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content,
                Delivery()
            ).commit()

            R.id.accountItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content,
                Account()
            ).commit()
        }

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            android.R.id.home -> {

                val mainMenu = MainMenu()
                mainMenu.show(
                    supportFragmentManager,
                    "main_menu"
                )

            }

        }

        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.top_menu, menu)

        return true
    }
}