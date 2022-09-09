package com.confluence.milo.view

import androidx.core.os.bundleOf
import com.confluence.milo.BR
import com.confluence.milo.R
import com.confluence.milo.databinding.FragmentUserBinding
import com.confluence.milo.viewmodel.MainViewModel
import com.confluence.milobox.adapter.BaseNoChildClickAdapter
import com.confluence.milobox.base.BaseFragment
import com.confluence.milobox.ex.defaultStyle
import com.confluence.milobox.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserFragment : BaseFragment() {

    override val viewModel: MainViewModel by viewModel()
    override val binding: FragmentUserBinding by lazy { viewBinding(FragmentUserBinding::inflate) }

    private val testAdapter: BaseNoChildClickAdapter<FragmentUserBinding, String> by lazy {
        BaseNoChildClickAdapter(BR.itemString, R.layout.item_test_list, (0..5).map { it.toString() }.toMutableList())
    }

    companion object {
        fun newInstance(index: Int): UserFragment {
            val fragment = UserFragment()
            fragment.arguments = bundleOf().apply {
                putInt("index", index)
            }
            return fragment
        }
    }

    override fun initView() {
        binding.indexTv.text = arguments?.getInt("index").toString()
        binding.userRv.defaultStyle(testAdapter)
    }

    override fun initVVMObserver() {
    }

    override fun initViewModelBindValue() {
    }

}

