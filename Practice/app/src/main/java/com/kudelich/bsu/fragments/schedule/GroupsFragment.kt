package com.kudelich.bsu.fragments.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kudelich.bsu.R

class GroupsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_faculties, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = GroupsFragment()
    }
}