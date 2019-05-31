package com.prashant.news.data.api

import com.google.gson.annotations.SerializedName
import com.prashant.news.data.model.NewsItem

data class NewsListApiResponse(@SerializedName("hits") val newsItems: List<NewsItem>)