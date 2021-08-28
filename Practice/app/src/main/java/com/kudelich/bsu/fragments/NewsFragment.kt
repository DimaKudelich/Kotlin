package com.kudelich.bsu.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kudelich.bsu.R
import com.kudelich.bsu.adapters.NewsAdapter

class NewsFragment : Fragment() {
    private val adapter = NewsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news, container, false)

        init()

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = NewsFragment()
    }

    private fun init() {
        val rcView: RecyclerView? = view?.findViewById(R.id.newsRec)
        if (rcView != null) {
            rcView.layoutManager = LinearLayoutManager(this.context)
            rcView.adapter = adapter
        }
    }
}