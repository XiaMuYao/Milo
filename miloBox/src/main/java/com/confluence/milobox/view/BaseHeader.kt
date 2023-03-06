package com.confluence.milobox.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.confluence.milobox.databinding.BaseHeaderBinding

/**
 * ================================================
 * 介    绍：
 * ================================================
 */
class BaseHeader : ConstraintLayout {

    //region constructor
    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        initView()
    }
    //endregion

    var baseHeaderCallBack: BaseHeaderCallBack? = null

    interface BaseHeaderCallBack {
        fun leftClickCallBack() {}
        fun rightClickCallBack() {}
    }

    lateinit var binding: BaseHeaderBinding

    private fun initView() {
        binding =
            BaseHeaderBinding.inflate(LayoutInflater.from(context), this, true)
        binding.headLeftIv.setOnClickListener { baseHeaderCallBack?.leftClickCallBack() }
        binding.headRightIv.setOnClickListener { baseHeaderCallBack?.rightClickCallBack() }
    }

}