package com.confluence.milobox

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.gyf.immersionbar.ImmersionBar


abstract class BaseActivity<V : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {
    lateinit var binding: V
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //私有的初始化 Data Binding 和 ViewModel 方法
        initViewDataBinding(savedInstanceState)
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
        //状态栏
        setImmersionBar()
    }

    @SuppressLint("PrivateResource")
    open fun setImmersionBar() {
        ImmersionBar.with(this)
    }

    open fun initBaseLiveDataCallBack() {

    }


    private fun initViewDataBinding(savedInstanceState: Bundle?) {
        binding = DataBindingUtil.setContentView(this, initContentView(savedInstanceState))
        createViewModel()
        //让 ViewModel 拥有View的生命周期感应
        binding.setVariable(initVariableId(), viewModel)
        binding.lifecycleOwner = this
    }

    /**
     * 创建ViewModel
     */
    open fun createViewModel() {
        viewModel = ViewModelProvider(this)[initViewModel()]
    }

    /**
     *  接受上一个界面传递的参数
     */
    open fun initParam() {

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
     * 初始化页面数据
     */
    open fun initData() {
        viewModel.initData()
    }



    /**
     * 初始化根布局
     *
     * @return 布局layout的id
     */
    abstract fun initContentView(savedInstanceState: Bundle?): Int

    /**
     * 初始化ViewModel的id
     *
     * @return BR的id
     */
    abstract fun initVariableId(): Int

    /**
     * initialize The ViewModel
     *
     * @return 继承BaseViewModel的ViewModel
     */
    abstract fun initViewModel(): Class<VM>


}
