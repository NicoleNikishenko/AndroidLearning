package com.example.androidlearning

import com.example.androidlearning.models.FavoriteList
import com.example.androidlearning.models.Image
import com.example.androidlearning.repositories.ImageListRepository
import com.example.androidlearning.viewmodels.MyViewModel
import mva2.adapter.ListSection
import mva2.adapter.MultiViewAdapter
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    //Defines a factory
    factory { ListSection<Image>() }

    //Defines a singleton
    single { FavoriteList(get()) }
    single { ImageListRepository() }


}
val viewModel = module {
    // MyViewModel ViewModel
    viewModel { MyViewModel(get()) }
}