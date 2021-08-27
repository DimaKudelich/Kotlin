package com.kudelich.bsu.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kudelich.bsu.R
import com.kudelich.bsu.adapters.ClassesAdapter
import com.kudelich.bsu.data.viewmodel.ClassViewModel
import kotlinx.android.synthetic.main.fragment_my_schedule.view.*

class MyScheduleFragment : Fragment() {
    private val adapter = ClassesAdapter()
    private lateinit var mClassViewModel: ClassViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_schedule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.swiperefresh.setOnRefreshListener {
            view.swiperefresh.isRefreshing = true

            insertData()

            view.swiperefresh.isRefreshing = false
        }
        
        init()
    }

    companion object {
        @JvmStatic
        fun newInstance() = MyScheduleFragment()
    }

    private fun init() {
        val rcView: RecyclerView? = view?.findViewById(R.id.myScheduleRec)
        if (rcView != null) {
            rcView.layoutManager = LinearLayoutManager(this.context)
            rcView.adapter = adapter

            mClassViewModel = ViewModelProvider(this).get(ClassViewModel::class.java)
            mClassViewModel.readAllData.observe(viewLifecycleOwner, Observer { classes ->
                adapter.setData(classes)
            })
        }
    }

    private fun insertData(){
//        val classes = Class(0,"16:00-17:20","UMF","606",1)
//        mClassViewModel.addClass(classes)
        Toast.makeText(this.context,"refreshing",Toast.LENGTH_LONG).show()
    }
}