package com.prashant.news.data.repository

import com.prashant.news.data.api.NewsListApiResponse
import io.reactivex.Single

interface NewsDataSource {
    fun loadNewsList(): Single<NewsListApiResponse>
}