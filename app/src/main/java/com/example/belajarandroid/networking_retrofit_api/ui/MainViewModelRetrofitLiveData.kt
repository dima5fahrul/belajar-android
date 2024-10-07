package com.example.belajarandroid.networking_retrofit_api.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.belajarandroid.networking_retrofit_api.data.response.CustomerReviewsItem
import com.example.belajarandroid.networking_retrofit_api.data.response.Restaurant

class MainViewModelRetrofitLiveData : ViewModel() {
    private val _restaurant = MutableLiveData<Restaurant>()
    val restaurant: LiveData<Restaurant> = _restaurant

    private val _listReview = MutableLiveData<List<CustomerReviewsItem>>()
    val listReview: LiveData<List<CustomerReviewsItem>> = _listReview

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading


    companion object {
        private const val TAG = "MainViewModelRetrofitLiveData"
        private const val RESTAURANT_ID = "uewq1zg2zlskfw1e867"
    }
}