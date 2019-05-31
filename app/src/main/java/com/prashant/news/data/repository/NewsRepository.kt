package com.prashant.news.data.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.prashant.news.common.Result
import com.prashant.news.data.model.NewsItem
import com.prashant.news.util.scheduler.RunOn
import com.prashant.news.util.scheduler.SchedulerType
import io.reactivex.Scheduler
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val remoteDataSource: NewsDataSource,
    @RunOn(SchedulerType.IO) private val ioScheduler: Scheduler,
    @RunOn(SchedulerType.UI) private val uiScheduler: Scheduler
) {

    fun loadNewsList(): LiveData<Result<List<NewsItem>>> {
        val newsItem = MutableLiveData<Result<List<NewsItem>>>()
        remoteDataSource.loadNewsList()
            .observeOn(uiScheduler)
            .subscribeOn(ioScheduler)
            .doOnSubscribe({
                newsItem.value = Result.loading()
            })
            .subscribe({
                newsItem.value = Result.success(it.newsItems)
            }, {
                newsItem.value = Result.error(it)
            })
        return newsItem
    }
}