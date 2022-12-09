package com.confluence.milobox.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.confluence.milobox.R
import com.confluence.milobox.databinding.BaseBottomMenuBinding
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
        fun back(){}
        fun menu(){}
    }

    lateinit var binding: BaseHeaderBinding

    private fun initView() {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.base_header,
            this,
            true
        )
        binding.backIv.setOnClickListener { baseHeaderCallBack?.back() }
        binding.menuIv.setOnClickListener { baseHeaderCallBack?.menu() }

    }


}