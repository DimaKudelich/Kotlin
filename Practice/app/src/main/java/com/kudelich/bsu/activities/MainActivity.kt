package com.kudelich.bsu.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.kudelich.bsu.R
import com.kudelich.bsu.data.viewmodel.ClassViewModel
import com.kudelich.bsu.databinding.ActivityMainBinding
import com.kudelich.bsu.entities.database.Class
import com.kudelich.bsu.fragments.MyScheduleFragment
import com.kudelich.bsu.fragments.NewsFragment
import com.kudelich.bsu.fragments.ProfileFragment
import com.kudelich.bsu.fragments.ScheduleSearchFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var classViewModel: ClassViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame, NewsFragment.newInstance())
            .commit()

        classViewModel = ViewModelProvider(this).get(ClassViewModel::class.java)
        //insertData()

        binding.botNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.news -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame, NewsFragment.newInstance())
                        .commit()
                }
                R.id.schedule -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame, ScheduleSearchFragment.newInstance())
                        .commit()
                }
                R.id.mySchedule -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame, MyScheduleFragment.newInstance())
                        .commit()
                }
                R.id.profile -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame, ProfileFragment.newInstance())
                        .commit()
                }
            }
            true
        }
    }

    private fun insertData(){
        val classes = Class(0,"16:00-17:20","UMF","606",1)
        classViewModel.addClass(classes)
        Toast.makeText(this,"Successfully added",Toast.LENGTH_SHORT).show()
    }
}