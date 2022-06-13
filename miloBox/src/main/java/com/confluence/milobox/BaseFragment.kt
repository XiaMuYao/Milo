package com.confluence.milobox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider


abstract class BaseFragment<V : ViewDataBinding, VM : BaseViewModel> : Fragment() {

    lateinit var binding: V
    lateinit var viewModel: VM
    open val activityOrFragment = false

    private var isLoadData: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, initContentView(inflater, container, savedInstanceState), container, false)

        //让ViewModel拥有View的生命周期感应
        binding.lifecycleOwner = this
        binding.setVariable(initVariableId(), viewModel)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBaseLiveDataCallBack()
        initParameter()
        initView()

        //注册基本的事件回调
        initVVMObserver()
    }

    override fun onResume() {
        super.onResume()
        if (lifecycle.currentState == Lifecycle.State.STARTED) {
            if (isLoadData.not()) {
                onLazyLoad()
            }
        }

    }

    fun initBaseLiveDataCallBack() {

    }

    /**
     * 创建ViewModel
     */
    open fun createViewModel() {
        viewModel = if (activityOrFragment) {
            ViewModelProvider(this)[initViewModel()]
        } else {
            ViewModelProvider(requireActivity())[initViewModel()]
        }
    }


    /**
     * 初始化V-VM之间的观察者回调
     */
    abstract fun initVVMObserver()

    /**
     * 初始化部分点击时间或者 view事件
     */
    abstract fun initView()

    /**
     * 初始化页面数据
     */
    protected open fun onLazyLoad() {
        isLoadData = true
        viewModel.initData()
        LL.d("${this::class.java.simpleName} onLazyLoad")
    }


    /**
     * 初始化根布局
     *
     * @return 布局layout的id
     */
    abstract fun initContentView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): Int

    /**
     * 初始化ViewModel的id
     *
     * @return BR的id
     */
    abstract fun initVariableId(): Int


    abstract fun initViewModel(): Class<VM>


    open fun initParameter() {}

}