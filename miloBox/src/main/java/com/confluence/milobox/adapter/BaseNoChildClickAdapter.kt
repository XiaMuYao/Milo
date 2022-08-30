package com.confluence.milobox.adapter

import androidx.databinding.ViewDataBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder

/**
 * 不需要子控件点击使用这个
 */
class BaseNoChildClickAdapter<BD : ViewDataBinding, T>(
    var itemBrId: Int,
    var itemLayoutId: Int,
    var sourceList: MutableList<T>?,
) : BaseQuickAdapter<T, BaseDataBindingHolder<BD>>(itemLayoutId, sourceList) {


    override fun convert(holder: BaseDataBindingHolder<BD>, item: T) {
        holder.dataBinding?.let {
            it.setVariable(itemBrId, item)
            it.executePendingBindings()
        }
    }


}