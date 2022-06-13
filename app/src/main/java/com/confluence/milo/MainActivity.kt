package com.confluence.milo

import android.os.Bundle
import com.confluence.milo.databinding.ActivityMainBinding
import com.confluence.milobox.BaseActivity
import com.confluence.milobox.LL


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override fun initView() {
        binding.button.setOnClickListener {
            LL.d("button")
        }
    }

    override fun initVVMObserver() {
    }

    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_main
    }

    override fun initVariableId(): Int {
        return BR.mainViewModel
    }

    override fun initViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }


}