package com.example.androidlearning.viewmodels

import androidx.lifecycle.ViewModel
import com.example.androidlearning.models.Image
import com.example.androidlearning.models.ImageList
import com.example.androidlearning.repositories.ImageListRepository
import org.koin.java.KoinJavaComponent

class MyViewModel(val repo : ImageListRepository) : ViewModel()  {

    private val firstSection = ImageList(repo.images)
    private val secondSection = ImageList(repo.images)


    fun getFirstSection(): ImageList? {
        return firstSection
    }

    fun getSecondSection(): ImageList? {
        return secondSection
    }
}
