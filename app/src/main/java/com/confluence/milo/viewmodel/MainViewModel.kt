package com.confluence.milo.viewmodel

import com.confluence.milo.model.MainRepository
import com.confluence.milobox.base.BaseViewModel
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * ================================================
 * 介    绍：
 * ================================================
 */
class MainViewModel(private val repository: MainRepository) : BaseViewModel() {

    override fun initData() {

    }


    fun getBanner() {
        request {
            val data = repository.getBanner()
            data
        }
    }


}