package com.prashant.news.di

import com.prashant.news.NewsApp
import com.prashant.news.common.ViewModelFactory
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBindingModule::class,
        NetworkModule::class
    )
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        fun build(): AppComponent

        @BindsInstance
        fun app(app: NewsApp): Builder

        @BindsInstance
        fun networkModule(module: NetworkModule): Builder
    }

    fun inject(app: NewsApp)

    fun getViewModelFactory(): ViewModelFactory
}