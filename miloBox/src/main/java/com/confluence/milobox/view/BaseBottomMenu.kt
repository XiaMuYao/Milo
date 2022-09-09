package com.confluence.milobox.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.confluence.milobox.LL
import com.confluence.milobox.R
import com.confluence.milobox.databinding.BaseBottomMenuBinding

/**
 * ================================================
 * 介    绍：
 * ================================================
 */
class BaseBottomMenu : ConstraintLayout {

    //region companion object
    enum class MainTabPage {
        HOME,
        MESSAGE,
        FIND,
        MY
    }

    //endregion

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

    private var baseBottomMenuCallBack: BaseBottomMenuCallBack? = null
    private var insideViewpager: ViewPager2? = null
    lateinit var binding: BaseBottomMenuBinding

    interface BaseBottomMenuCallBack {
        fun menuSelectCallBack(id: MainTabPage, ordinal: Int)
        fun onPageSelected(position: Int)
    }

    fun setCallBackAndViewPager(viewPager: ViewPager2,callBack: BaseBottomMenuCallBack) {
        baseBottomMenuCallBack = callBack
        insideViewpager = viewPager

        insideViewpager?.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                baseBottomMenuCallBack?.onPageSelected(position)
                LL.d("position::${position}")
            }
        })
    }

    private fun initView() {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.base_bottom_menu,
            this,
            true
        )

        binding.homeIv.setOnClickListener {
            select((MainTabPage.HOME))
        }
        binding.homeTv.setOnClickListener {
            select((MainTabPage.HOME))
        }

        binding.messageIv.setOnClickListener {
            select((MainTabPage.MESSAGE))
        }
        binding.messageTv.setOnClickListener {
            select((MainTabPage.MESSAGE))
        }

        binding.findIv.setOnClickListener {
            select((MainTabPage.FIND))
        }
        binding.findTv.setOnClickListener {
            select((MainTabPage.FIND))
        }

        binding.myIv.setOnClickListener {
            select((MainTabPage.MY))
        }
        binding.myTv.setOnClickListener {
            select((MainTabPage.MY))
        }
    }

    private fun select(tab: MainTabPage) {
        insideViewpager?.currentItem = tab.ordinal
        baseBottomMenuCallBack?.menuSelectCallBack(tab, tab.ordinal)
    }
}