package com.prashant.news.ui.newslist

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.prashant.news.common.Result
import com.prashant.news.data.model.NewsItem
import com.prashant.news.data.repository.NewsRepository

class NewsListViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    fun loadNewsList(): LiveData<Result<List<NewsItem>>> {
        return newsRepository.loadNewsList()
    }
}