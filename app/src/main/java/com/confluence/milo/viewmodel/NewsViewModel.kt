package com.confluence.milo.viewmodel

import com.confluence.milobox.indicator.IndicatorBean
import com.confluence.milobox.base.BaseViewModel

/**
 * ================================================
 * 介    绍：
 * ================================================
 */
class NewsViewModel : BaseViewModel() {
    val indicatorList = arrayListOf(
        IndicatorBean(1001, "头条"),
        IndicatorBean(1002, "热榜"),
    )

    override fun initData() {

    }



}