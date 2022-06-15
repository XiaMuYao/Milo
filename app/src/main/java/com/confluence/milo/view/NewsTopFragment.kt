package com.confluence.milo.view

import androidx.fragment.app.Fragment
import com.confluence.milo.databinding.FragmentNewTopBinding
import com.confluence.milo.viewmodel.NewsTopViewModel
import com.confluence.milobox.adapter.BaseViewPagerAdapter
import com.confluence.milobox.base.BaseFragment
import com.confluence.milobox.indicator.SingleLineAdapter
import com.confluence.milobox.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class NewsTopFragment : BaseFragment() {
    override val viewModel: NewsTopViewModel by viewModel()
    override val binding: FragmentNewTopBinding by lazy { viewBinding(FragmentNewTopBinding::inflate) }

    companion object {
        fun newInstance(): NewsTopFragment {
            return NewsTopFragment()
        }
    }

    override fun initView() {
        val tempListFragment = mutableListOf<Fragment>()

        for (i in 0..viewModel.indicatorList.size) {
            tempListFragment.add(NewsTopListFragment.newInstance())
        }

        binding.viewPager.adapter = BaseViewPagerAdapter(
            requireActivity(), tempListFragment
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
        binding.newsTopViewModel = viewModel
    }


}

