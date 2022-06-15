package com.confluence.milobox.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BaseViewModel() : ViewModel(){
    //上拉加载结束
    val loadMoreStatus = MutableLiveData<Boolean>()
    //下拉刷新结束
    val refreshStatus = MutableLiveData<Boolean>()
    //是否还有更多数据
    val hasMore = MutableLiveData(true)
    //loadOk
    var loadOK = MutableLiveData<Boolean>()
    //loading
    var showLoading = MutableLiveData<Boolean>()

    abstract fun initData()

    open fun <T> request(block: suspend () -> T): Job {
        return viewModelScope.launch(Dispatchers.IO) {
            try {
                block()
            } catch (t: Throwable) {
                t.printStackTrace()
            }
        }
    }

    fun showLoading() {
        showLoading.postValue(true)
    }

    fun dissLoading() {
        showLoading.postValue(false)
    }

}