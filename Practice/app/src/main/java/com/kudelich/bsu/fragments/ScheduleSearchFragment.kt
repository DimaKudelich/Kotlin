package com.kudelich.bsu.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kudelich.bsu.R
import com.kudelich.bsu.adapters.SearchAdapter
import com.kudelich.bsu.data.viewmodel.FacultyViewModel

class ScheduleSearchFragment : Fragment() {
    private val adapter = SearchAdapter()
    private lateinit var mFacultyViewModel: FacultyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_schedule_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mFacultyViewModel = ViewModelProvider(this).get(FacultyViewModel::class.java)
        mFacultyViewModel.readAllData.observe(viewLifecycleOwner, Observer { faculty->
            adapter.setData(faculty)
        })
        init()
    }

    private fun init() {
        val rcView: RecyclerView? = view?.findViewById(R.id.search_rec)
        if (rcView != null) {
            rcView.layoutManager = LinearLayoutManager(this.context)
            rcView.adapter = adapter
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ScheduleSearchFragment()
    }
}