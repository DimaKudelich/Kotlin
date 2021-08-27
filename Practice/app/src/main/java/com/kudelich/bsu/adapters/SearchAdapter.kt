package com.kudelich.bsu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kudelich.bsu.R
import com.kudelich.bsu.entities.database.Faculty
import kotlinx.android.synthetic.main.card_search.view.*

class SearchAdapter: RecyclerView.Adapter<SearchAdapter.SearchHolder>() {
    private var searches = emptyList<Faculty>()

    class SearchHolder(item: View) : RecyclerView.ViewHolder(item) {
        fun bind(search: Faculty) {
            itemView.search_data.text = search.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_search, parent, false)
        return SearchHolder(view)
    }

    override fun onBindViewHolder(holder: SearchHolder, position: Int) {
        holder.bind(searches[position])
//        holder.itemView.search_row.setOnClickListener {
//            setData(courses)
//        }
    }

    override fun getItemCount(): Int {
        return searches.size
    }

    fun setData(searches: List<Faculty>){
        this.searches = searches
        notifyDataSetChanged()
    }
}