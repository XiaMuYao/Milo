package com.confluence.milobox.indicator

import android.graphics.Color
import github.xuqk.kdtablayout.KDTabAdapter
import github.xuqk.kdtablayout.KDTabLayout
import github.xuqk.kdtablayout.widget.KDTab
import github.xuqk.kdtablayout.widget.KDTabIndicator
import github.xuqk.kdtablayout.widget.tab.KDColorClipTextTab

/**
 * ================================================
 * 介    绍：
 * ================================================
 */
class SingleLineAdapter(
    var kdTabLayout: KDTabLayout,
    var tagList: MutableList<IndicatorBean>,
    var clickFunction: (Int) -> Unit,
) : KDTabAdapter() {
    override fun createTab(position: Int): KDTab {
        return KDColorClipTextTab(kdTabLayout.context, tagList[position].indicatorName).apply {
            horizontalPadding = 16f
            selectedTextSize = 22f
            normalTextSize = 16f
            selectedTextColor = Color.parseColor("#1e1e1e")
            normalTextColor = Color.parseColor("#828282")
            setOnClickListener {
                clickFunction(position)
            }
        }
    }

    override fun createIndicator(): KDTabIndicator? {
        return null
    }

    override fun getTabCount(): Int {
        return tagList.size
    }
}