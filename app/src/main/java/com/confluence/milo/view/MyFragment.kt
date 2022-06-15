package com.confluence.milo.view

import com.confluence.milo.databinding.FragmentMyBinding
import com.confluence.milo.viewmodel.MainViewModel
import com.confluence.milobox.base.BaseFragment
import com.confluence.milobox.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyFragment : BaseFragment() {
    override val viewModel: MainViewModel by viewModel()
    override val binding: FragmentMyBinding by lazy { viewBinding(FragmentMyBinding::inflate) }

    companion object {
        fun newInstance(): MyFragment {
            return MyFragment()
        }
    }

    override fun initView() {

    }

    override fun initVVMObserver() {
    }

    override fun initViewModelBindValue() {
    }


}

