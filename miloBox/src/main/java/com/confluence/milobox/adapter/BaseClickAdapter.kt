package com.confluence.milobox.adapter

import androidx.databinding.ViewDataBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder


/**
 * 添加子控件点击事件
 */
class BaseClickAdapter<T, BD : ViewDataBinding>(layout: Int, data: MutableList<T>?, var brId: Int, var childList: List<Int>?=null) :
    BaseQuickAdapter<T, BaseDataBindingHolder<BD>>(layout, data) {

    override fun convert(holder: BaseDataBindingHolder<BD>, item: T) {
        holder.dataBinding?.apply {
            setVariable(brId, item)
            executePendingBindings()
        }
        childList?.map { addChildClickViewIds(it) }
    }

}