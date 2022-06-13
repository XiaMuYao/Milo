package com.confluence.milo

import com.confluence.milobox.BaseViewModel

/**
 * ================================================
 * 介    绍：
 * ================================================
 */
class MainViewModel : BaseViewModel() {

    private val repository by lazy { MainRepository() }

    override fun initData() {

    }

    fun getListData() {
        request {
            repository.getUserList()
        }
    }


}