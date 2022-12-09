package com.confluence.milobox.extension

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter

/**
 * ================================================
 * 介    绍：
 * ================================================
 */
fun RecyclerView.defaultStyle(
    mAdapter: BaseQuickAdapter<*, *>,
    LayoutManager: RecyclerView.LayoutManager? = LinearLayoutManager(context)
) {
    this.adapter = mAdapter
    this.layoutManager = LayoutManager
}