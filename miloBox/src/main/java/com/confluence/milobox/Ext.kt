package com.confluence.milobox

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.confluence.milobox.base.BaseFragment


/**
 * ================================================
 * 介    绍：
 * ================================================
 */
fun RecyclerView.defaultMultiStyle(
    mAdapter: BaseQuickAdapter<*, *>,
    LayoutManager: RecyclerView.LayoutManager? = LinearLayoutManager(context.applicationContext),
) {
    this.adapter = mAdapter
    this.layoutManager = LayoutManager
}


inline fun <T : ViewBinding> Activity.viewBinding(crossinline inflate: (LayoutInflater) -> T) = lazy { inflate(layoutInflater) }

inline fun <T : ViewBinding> BaseFragment.viewBinding(
    crossinline inflate: (LayoutInflater, ViewGroup?, Boolean) -> T,
): T {
    val binding = inflate(layoutInflater, container, false)
    container = null
    return binding
}
