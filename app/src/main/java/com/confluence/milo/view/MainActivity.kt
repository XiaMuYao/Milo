package com.confluence.milo.view

import com.confluence.milo.R
import com.confluence.milo.databinding.ActivityMainBinding
import com.confluence.milo.viewmodel.MainViewModel
import com.confluence.milobox.adapter.BaseViewPagerAdapter
import com.confluence.milobox.base.BaseActivity
import com.confluence.milobox.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : BaseActivity() {

    override val viewModel: MainViewModel by viewModel()
    override val binding by viewBinding(ActivityMainBinding::inflate)

    private val mainViewPagerAdapter =
        BaseViewPagerAdapter(
            this,
            arrayListOf(
                NewsFragment.newInstance(),
                CommunityFragment.newInstance(),
                MyFragment.newInstance()
            )
        )

    override fun initView() {
        binding.viewPager.adapter = mainViewPagerAdapter
        binding.navigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.actionNew -> {
                    binding.viewPager.currentItem = 0
                    return@setOnItemSelectedListener true
                }
                R.id.actionCommunity -> {
                    binding.viewPager.currentItem = 1
                    return@setOnItemSelectedListener true
                }
                R.id.actionMy -> {
                    binding.viewPager.currentItem = 2
                    return@setOnItemSelectedListener true

                }
                else -> {
                    return@setOnItemSelectedListener true

                }
            }
        }
    }

    override fun initVVMObserver() {

    }

    override fun initViewModelBindValue() {
        binding.mainViewModel = viewModel
    }
}