package com.example.eshop.ViewModel

import androidx.lifecycle.LiveData
import com.example.eshop.domain.BannerModel
import com.example.eshop.domain.CategoryModel

class DashboardViewModel {
    private val repository = DashboardViewModel()

    fun loadCategory() : LiveData<MutableList<CategoryModel>> {
        return repository.loadCategory()
    }

    fun loadBanners() : LiveData<MutableList<BannerModel>> {
        return repository.loadBanners()
    }
}