package com.kudelich.bsu.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kudelich.bsu.R
import com.kudelich.bsu.adapters.ProfileAdapter

class ProfileFragment : Fragment() {
    private val adapter = ProfileAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View? = inflater.inflate(R.layout.fragment_profile, container, false)

        init()

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProfileFragment()
    }

    private fun init() {
        val rcView: RecyclerView? = view?.findViewById(R.id.profileRec)
        if (rcView != null) {
            rcView.layoutManager = LinearLayoutManager(this.context)
            rcView.adapter = adapter
        }
    }
}