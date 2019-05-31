package com.prashant.news.ui.newslist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.prashant.news.R
import com.prashant.news.data.model.NewsItem

class NewsListAdapter(var newsItems: List<NewsItem>) : RecyclerView.Adapter<NewsListViewHolder>() {

    override fun onCreateViewHolder(vg: ViewGroup, viewType: Int): NewsListViewHolder {
        return NewsListViewHolder(LayoutInflater.from(vg.context).inflate(R.layout.item_news_list, vg, false))
    }

    override fun getItemCount(): Int {
        return newsItems.size
    }

    override fun onBindViewHolder(viewHolder: NewsListViewHolder, position: Int) {
        viewHolder.bind(newsItems.get(position))
    }
}