package com.confluence.milobox.base

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import com.gyf.immersionbar.ImmersionBar


abstract class BaseActivity : AppCompatActivity() {
    abstract val binding: ViewDataBinding

    abstract val viewModel: BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //私有的初始化 Data Binding 和 ViewModel 方法
        initViewDataBinding()
        //页面传参
        initParam()
        //View 初始化
        initView()
        //初始化 V <--> VM LiveData 改变 V
        initVVMObserver()
        //注册基本的事件回调
        initBaseLiveDataCallBack()
        //初始化数据
        initData()
        //初始化 xml 和 viewModel 绑定
        initViewModelBindValue()
        //状态栏
        setImmersionBar()
    }


    @SuppressLint("PrivateResource")
    open fun setImmersionBar() {
        ImmersionBar.with(this)
    }

    open fun initBaseLiveDataCallBack() {}


    private fun initViewDataBinding() {
        binding.lifecycleOwner = this
        setContentView(binding.root)
    }

    /**
     *  接受上一个界面传递的参数
     */
    open fun initParam() {}

    /**
     * 初始化页面数据
     */
    open fun initData() {
        viewModel.initData()
    }

    /**
     * 初始化View
     */
    abstract fun initView()

    /**
     * 初始化V-VM之间的观察者回调
     */
    abstract fun initVVMObserver()

    /**
     * 初始化 xml 和 viewModel 绑定
     */
    abstract fun initViewModelBindValue()


}
