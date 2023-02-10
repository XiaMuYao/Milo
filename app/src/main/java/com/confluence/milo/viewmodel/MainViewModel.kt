package com.confluence.milo.viewmodel

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

    override fun initData() {

    }


    fun getSerialCall() {
        request {
            val data = repository.friendWeb()
            LL.d("结果:${data}")
        }
    }

    fun getSAsyncCall() {
        request {
            val data1 = repository.getAsyncBanner()
            LL.d("结果:${data1}")
        }
    }


}