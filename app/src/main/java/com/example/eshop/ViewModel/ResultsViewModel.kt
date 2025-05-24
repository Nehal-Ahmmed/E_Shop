package com.example.eshop.ViewModel

import androidx.lifecycle.LiveData
import com.example.eshop.Repository.ResultsRepository
import com.example.eshop.domain.CategoryModel
import com.example.eshop.domain.StoreModel

class ResultsViewModel {
    private val repository = ResultsRepository()

    fun loadSubCategory(id: String) : LiveData<MutableList<CategoryModel>> {
        return repository.loadSubCategory(id)
    }

    fun loadPopular(id: String) : LiveData<MutableList<StoreModel>> {
        return repository.loadPopular(id)
    }

    fun loadNearest(id: String) : LiveData<MutableList<StoreModel>> {
        return repository.loadNearest(id)
    }
}