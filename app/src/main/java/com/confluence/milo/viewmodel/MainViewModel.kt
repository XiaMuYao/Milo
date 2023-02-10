package com.confluence.milo.viewmodel

import androidx.lifecycle.MutableLiveData
import com.confluence.milo.model.MainRepository
import com.confluence.milobox.base.BaseViewModel
import com.confluence.milobox.utils.LL
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * ================================================
 * 介    绍：
 * ================================================
 */
@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : BaseViewModel() {

    var flowLiveData = MutableLiveData<Any>()

    override fun initData() {

    }


    fun getSerialCall() {
        request {
            val data = repository.friendWeb()
            LL.d("结果:${data}")
        }
    }

    fun getAsyncCall() {
        request {
            val data1 = repository.getAsyncBanner()
            LL.d("结果:${data1}")
        }
    }


    fun getUserList() {
        request {
            val userData = repository.getUserData()
            LL.d("$userData")
        }
    }

    fun saveUserData() {
        request {
            repository.saveUserData()
        }
    }

    fun getFlowData() {
        request {
            val flowData = repository.getFlowData()
            flowData.collect {
                flowLiveData.postValue(it)
                LL.d("it:${it}")
            }
        }
    }


}