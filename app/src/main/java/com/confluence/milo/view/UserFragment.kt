package com.confluence.milo.view

import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.confluence.milo.BR
import com.confluence.milo.R
import com.confluence.milo.databinding.FragmentUserBinding
import com.confluence.milo.viewmodel.MainViewModel
import com.confluence.milobox.adapter.BaseNoChildClickAdapter
import com.confluence.milobox.base.BaseFragment
import com.confluence.milobox.extension.defaultStyle
import com.confluence.milobox.extension.viewBinding
import com.confluence.milobox.utils.LL
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserFragment : BaseFragment() {

    override val viewModel: MainViewModel by viewModels()
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
        testAdapter.setOnItemClickListener { adapter, _, position ->
            LL.d("data ${adapter.items[position]}")
        }
    }

    override fun initVVMObserver() {
    }

    override fun initViewModelBindValue() {
    }

}

