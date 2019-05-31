package com.prashant.news.ui.newslist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.prashant.news.common.Result
import com.prashant.news.common.ViewModelFactory
import com.prashant.news.data.model.NewsItem
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_news_list.*
import javax.inject.Inject
import android.support.v7.widget.DividerItemDecoration




class NewsListActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var newsListViewModel: NewsListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(com.prashant.news.R.layout.activity_news_list)
        newsListViewModel = ViewModelProviders.of(this, viewModelFactory)[NewsListViewModel::class.java]
        newsListViewModel.loadNewsList().observe(this, Observer {
            when (it?.status) {
                Result.SUCCESS -> {
                    hideLoadingIndicator()
                    handleNewsListResult(it.data)
                }
                Result.LOADING -> showLoadingIndicator()
                Result.ERROR -> {
                    hideLoadingIndicator()
                    showNewsListError(it.error)
                }
            }
        })
    }

    private fun showNewsListError(t: Throwable?) {
        t?.let { Snackbar.make(mainContainer, it.localizedMessage, Snackbar.LENGTH_LONG).show() }
    }

    private fun handleNewsListResult(data: List<NewsItem>?) {
        data?.let {
            with(rvNewsList) {
                addItemDecoration(DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL))
                layoutManager = LinearLayoutManager(NewsListActivity@ this.context)
                adapter = NewsListAdapter(it)
            }
        }
    }

    private fun showLoadingIndicator() {
        pbNewsList.visibility = View.VISIBLE
    }

    private fun hideLoadingIndicator() {
        pbNewsList.visibility = View.GONE
    }
}
