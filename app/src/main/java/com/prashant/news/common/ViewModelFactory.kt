package com.prashant.news.common

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.prashant.news.data.repository.NewsRepository
import com.prashant.news.ui.newslist.NewsListViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val newsRepository: NewsRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(NewsListViewModel::class.java) -> return NewsListViewModel(newsRepository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}