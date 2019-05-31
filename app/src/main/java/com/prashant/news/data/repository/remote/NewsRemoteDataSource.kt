package com.prashant.news.data.repository.remote

import com.prashant.news.data.api.NewsApiService
import com.prashant.news.data.api.NewsListApiResponse
import com.prashant.news.data.repository.NewsDataSource
import io.reactivex.Single
import javax.inject.Inject

class NewsRemoteDataSource @Inject constructor(val apiService: NewsApiService) : NewsDataSource {

    override fun loadNewsList(): Single<NewsListApiResponse> {
        return apiService.getNews()
    }
}