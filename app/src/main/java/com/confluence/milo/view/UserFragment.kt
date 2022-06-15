package com.confluence.milo.view

import com.confluence.milo.databinding.FragmentUserBinding
import com.confluence.milo.viewmodel.MainViewModel
import com.confluence.milobox.base.BaseFragment
import com.confluence.milobox.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserFragment : BaseFragment() {
    override val viewModel: MainViewModel by viewModel()
    override val binding: FragmentUserBinding by lazy { viewBinding(FragmentUserBinding::inflate) }

    companion object {
        fun newInstance(): UserFragment {
            return UserFragment()
        }
    }

    override fun initView() {
        binding.textView.setOnClickListener { viewModel.getListData() }
    }

    override fun initVVMObserver() {
    }

    override fun initViewModelBindValue() {
    }


}

