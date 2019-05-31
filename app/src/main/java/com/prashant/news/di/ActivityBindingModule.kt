package com.prashant.news.di

import com.prashant.news.ui.newslist.NewsListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBindingModule {

    @ContributesAndroidInjector
    fun bindNewsListActivity(): NewsListActivity
}