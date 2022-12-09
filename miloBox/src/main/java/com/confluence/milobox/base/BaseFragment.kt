package com.confluence.milobox.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.confluence.milobox.utils.LL


abstract class BaseFragment : Fragment() {
    abstract val viewModel: BaseViewModel
    abstract val binding: ViewDataBinding

    private var isLoadData: Boolean = false

    var container: ViewGroup? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        this.container = container
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBaseLiveDataCallBack()
        initParameter()
        initViewModelBindValue()
        initView()
        //注册基本的事件回调
        initVVMObserver()
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

    open fun initBaseLiveDataCallBack() {}


    /**
     * 初始化页面数据
     */
    protected open fun onLazyLoad() {
        isLoadData = true
        viewModel.initData()
        LL.d("${this::class.java.simpleName} onLazyLoad")
    }

    open fun initParameter() {}

    override fun onResume() {
        super.onResume()
        if (lifecycle.currentState == Lifecycle.State.STARTED) {
            if (isLoadData.not()) {
                onLazyLoad()
            }
        }

    }

}