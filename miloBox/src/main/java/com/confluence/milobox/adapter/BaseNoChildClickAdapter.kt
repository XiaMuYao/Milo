package com.confluence.milobox.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.DataBindingHolder

/**
 * 不需要子控件点击使用这个
 */
class BaseNoChildClickAdapter<BD : ViewDataBinding, T>(
    var itemBrId: Int,
    var itemLayoutId: Int,
    sourceList: List<T>,
) : BaseQuickAdapter<T, DataBindingHolder<BD>>(sourceList) {


    override fun onBindViewHolder(holder: DataBindingHolder<BD>, position: Int, item: T?) {
        holder.binding.let {
            it.setVariable(itemBrId, item)
            it.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(context: Context, parent: ViewGroup, viewType: Int): DataBindingHolder<BD> {
        return DataBindingHolder(itemLayoutId, parent)
    }


}