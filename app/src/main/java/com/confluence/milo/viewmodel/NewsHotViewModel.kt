package com.confluence.milo.viewmodel

import com.confluence.milobox.indicator.IndicatorBean
import com.confluence.milobox.base.BaseViewModel

/**
 * ================================================
 * 介    绍：
 * ================================================
 */
class NewsHotViewModel : BaseViewModel() {

    val indicatorList = arrayListOf(
        IndicatorBean(11, "DOTA2"),
        IndicatorBean(12, "LOL"),
        IndicatorBean(13, "CSGO"),
        IndicatorBean(14, "王者荣耀")
    )

    override fun initData() {

    }



}