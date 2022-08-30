package com.confluence.milo.view

import com.confluence.milo.databinding.ActivityMainBinding
import com.confluence.milo.viewmodel.MainViewModel
import com.confluence.milobox.LL
import com.confluence.milobox.adapter.BaseViewPagerAdapter
import com.confluence.milobox.base.BaseActivity
import com.confluence.milobox.view.BaseBottomMenu
import com.confluence.milobox.view.BaseHeader
import com.confluence.milobox.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    override val viewModel: MainViewModel by viewModel()
    override val binding by viewBinding(ActivityMainBinding::inflate)

    private val mainViewPagerAdapter =
        BaseViewPagerAdapter(this, arrayListOf(UserFragment.newInstance(), UserFragment.newInstance(), UserFragment.newInstance()))

    override fun initView() {
        binding.ViewPager2.adapter = mainViewPagerAdapter
        binding.bottomMenuBBM.setCallBackAndViewPager(object : BaseBottomMenu.BaseBottomMenuCallBack {
            override fun menuSelectCallBack(id: BaseBottomMenu.MainTabPage, ordinal: Int) {
                LL.d("id::${id}")
            }
        }, binding.ViewPager2)
        binding.headerBH.baseHeaderCallBack = object : BaseHeader.BaseHeaderCallBack {
            override fun back() {
                LL.d("back")
            }

            override fun menu() {
                LL.d("menu")
            }
        }
    }

    override fun initVVMObserver() {

    }

    override fun initViewModelBindValue() {
        binding.mainViewModel = viewModel
    }
}