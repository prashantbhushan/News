package com.prashant.news.ui.newslist

import android.support.v7.widget.RecyclerView
import android.view.View
import com.prashant.news.data.model.NewsItem
import kotlinx.android.synthetic.main.item_news_list.view.*

class NewsListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(newsItem: NewsItem) {
        itemView.tvTitle.text = newsItem.title
    }
}