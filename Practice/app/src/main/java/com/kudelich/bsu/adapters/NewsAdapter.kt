package com.kudelich.bsu.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kudelich.bsu.R
import com.kudelich.bsu.entities.News
import kotlinx.android.synthetic.main.card_news.view.*

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsHolder>() {
    private val news = listOf<News>(
        News(R.id.logo, "news 1"),
        News(R.id.logo, "news 2"),
        News(R.id.logo, "news 3"),
        News(R.id.logo, "news 4"),
        News(R.id.logo, "news 5"),
        News(R.id.logo, "news 6")
    )

    class NewsHolder(item: View) : RecyclerView.ViewHolder(item) {
        fun bind(news: News) {
//            val img: ImageView = itemView.findViewById(R.id.newsImg)
//            img.setImageResource(news.newsImg)

            itemView.newsTxt.text = news.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_news, parent, false)
        return NewsHolder(view)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.bind(news[position])
    }

    override fun getItemCount(): Int {
        return news.size
    }
}