package com.confluence.milo

import com.confluence.milo.databinding.ActivityTestBinding
import com.confluence.milobox.base.BaseActivity
import com.confluence.milobox.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * ================================================
 * 介    绍：
 * ================================================
 */
class TestActivity : BaseActivity() {

    override val viewModel: TestViewModel by viewModel()
    override val binding by viewBinding(ActivityTestBinding::inflate)


    override fun initView() {
    }

    override fun initVVMObserver() {
    }

    override fun initViewModelBindValue() {
        binding.testViewModel = viewModel
    }
}