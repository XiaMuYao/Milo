package com.confluence.milo.view

import com.confluence.milo.databinding.FragmentCommunityBinding
import com.confluence.milo.viewmodel.MainViewModel
import com.confluence.milobox.base.BaseFragment
import com.confluence.milobox.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CommunityFragment : BaseFragment() {
    override val viewModel: MainViewModel by viewModel()
    override val binding: FragmentCommunityBinding by lazy { viewBinding(FragmentCommunityBinding::inflate) }

    companion object {
        fun newInstance(): CommunityFragment {
            return CommunityFragment()
        }
    }

    override fun initView() {

    }

    override fun initVVMObserver() {
    }

    override fun initViewModelBindValue() {
    }


}

