package com.prashant.news.data.api

import io.reactivex.Single
import retrofit2.http.GET

interface NewsApiService {
    @GET("v1/search")
    fun getNews(): Single<NewsListApiResponse>
}