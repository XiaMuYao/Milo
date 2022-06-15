package com.confluence.milo.view

import com.confluence.milo.databinding.FragmentNewsBinding
import com.confluence.milo.viewmodel.NewsViewModel
import com.confluence.milobox.adapter.BaseViewPagerAdapter
import com.confluence.milobox.base.BaseFragment
import com.confluence.milobox.indicator.SingleLineAdapter
import com.confluence.milobox.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFragment : BaseFragment() {
    override val viewModel: NewsViewModel by viewModel()
    override val binding: FragmentNewsBinding by lazy { viewBinding(FragmentNewsBinding::inflate) }

    companion object {
        fun newInstance(): NewsFragment {
            return NewsFragment()
        }
    }

    override fun initView() {
        binding.viewPager.adapter = BaseViewPagerAdapter(
            requireActivity(), arrayListOf(
                NewsTopFragment.newInstance(),
                NewsHotFragment.newInstance()
            )
        )

        binding.magicIndicator.apply {
            contentAdapter = SingleLineAdapter(this, viewModel.indicatorList) {
                binding.viewPager.currentItem = it
            }
            setViewPager2(binding.viewPager)
        }

    }

    override fun initVVMObserver() {
    }

    override fun initViewModelBindValue() {
    }


}

