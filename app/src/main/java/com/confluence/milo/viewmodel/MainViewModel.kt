package com.confluence.milo.viewmodel

import com.confluence.milo.model.MainRepository
import com.confluence.milobox.base.BaseViewModel

/**
 * ================================================
 * 介    绍：
 * ================================================
 */
class MainViewModel(private val repository: MainRepository) : BaseViewModel() {

    override fun initData() {

    }

    fun getListData() {
        request {
            repository.getUserList()
        }
    }


}