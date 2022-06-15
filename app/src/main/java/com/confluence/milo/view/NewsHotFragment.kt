package com.confluence.milo.view

import androidx.fragment.app.Fragment
import com.confluence.milo.databinding.FragmentNewHotBinding
import com.confluence.milo.viewmodel.MainViewModel
import com.confluence.milo.viewmodel.NewsHotViewModel
import com.confluence.milobox.base.BaseFragment
import com.confluence.milobox.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsHotFragment : BaseFragment() {
    override val viewModel: NewsHotViewModel by viewModel()
    override val binding: FragmentNewHotBinding by lazy { viewBinding(FragmentNewHotBinding::inflate) }

    companion object {
        fun newInstance(): NewsHotFragment {
            return NewsHotFragment()
        }
    }

    override fun initView() {
        val tempListFragment = mutableListOf<Fragment>()

        for (i in 0..viewModel.indicatorList.size) {
            tempListFragment.add(NewsTopListFragment.newInstance())
        }
    }

    override fun initVVMObserver() {
    }

    override fun initViewModelBindValue() {
    }


}

