package com.prashant.news.di

import com.prashant.news.data.repository.NewsRepository
import com.prashant.news.data.repository.remote.NewsRemoteDataSource
import com.prashant.news.util.scheduler.RunOn
import com.prashant.news.util.scheduler.SchedulerType
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun providesNewsRepository(
        remoteDataSource: NewsRemoteDataSource,
        @RunOn(SchedulerType.IO) ioScheduler: Scheduler,
        @RunOn(SchedulerType.UI) uiScheduler: Scheduler
    ): NewsRepository {
        return NewsRepository(remoteDataSource, ioScheduler, uiScheduler)
    }

    @Provides
    @RunOn(SchedulerType.IO)
    fun provideIO() = Schedulers.io()

    @Provides
    @RunOn(SchedulerType.UI)
    fun provideUI() = AndroidSchedulers.mainThread()
}