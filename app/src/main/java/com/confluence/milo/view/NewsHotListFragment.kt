package com.confluence.milo.view

import androidx.recyclerview.widget.DividerItemDecoration
import com.confluence.milo.BR
import com.confluence.milo.R
import com.confluence.milo.databinding.FragmentNewTopListBinding
import com.confluence.milo.databinding.ItemNewTopBinding
import com.confluence.milo.model.NewTopListBean
import com.confluence.milo.viewmodel.NewTopListViewModel
import com.confluence.milobox.adapter.BaseClickAdapter
import com.confluence.milobox.base.BaseFragment
import com.confluence.milobox.defaultMultiStyle
import com.confluence.milobox.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class NewsHotListFragment : BaseFragment() {
    override val viewModel: NewTopListViewModel by viewModel()
    override val binding: FragmentNewTopListBinding by lazy { viewBinding(FragmentNewTopListBinding::inflate) }

    companion object {
        fun newInstance(): NewsHotListFragment {
            return NewsHotListFragment()
        }
    }

    private var newTopListAdapter =
        BaseClickAdapter<NewTopListBean, ItemNewTopBinding>(
            R.layout.item_new_top, arrayListOf(

                NewTopListBean().apply {
                    imageUrl =
                        "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fblog%2F202107%2F17%2F20210717232533_2edcf.thumb.1000_0.jpg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1657892753&t=fabab1c5d5c397f932046d41e2578f5e"
                    userName = "张宏胜"
                    createTime = "05月03日"
                    createType = "知名赛事主持人"
                    title = "设置是否在没有更多数据之后 Footer 跟随内容"
                    titleImage =
                        "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fblog%2F202107%2F17%2F20210717232533_2edcf.thumb.1000_0.jpg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1657892753&t=fabab1c5d5c397f932046d41e2578f5e"
                },
                NewTopListBean().apply {
                    imageUrl =
                        "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fblog%2F202107%2F17%2F20210717232533_2edcf.thumb.1000_0.jpg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1657892753&t=fabab1c5d5c397f932046d41e2578f5e"
                    userName = "张宏胜"
                    createTime = "05月03日"
                    createType = "知名赛事主持人"
                    title = "设置是否在没有更多数据之后 Footer 跟随内容"
                    titleImage =
                        "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fblog%2F202107%2F17%2F20210717232533_2edcf.thumb.1000_0.jpg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1657892753&t=fabab1c5d5c397f932046d41e2578f5e"
                },
                NewTopListBean().apply {
                    imageUrl =
                        "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fblog%2F202107%2F17%2F20210717232533_2edcf.thumb.1000_0.jpg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1657892753&t=fabab1c5d5c397f932046d41e2578f5e"
                    userName = "张宏胜"
                    createTime = "05月03日"
                    createType = "知名赛事主持人"
                    title = "设置是否在没有更多数据之后 Footer 跟随内容"
                    titleImage =
                        "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fblog%2F202107%2F17%2F20210717232533_2edcf.thumb.1000_0.jpg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1657892753&t=fabab1c5d5c397f932046d41e2578f5e"
                },


                ), BR.itemNewTopListBean
        )

    override fun initView() {
        binding.recyclerView.apply {
            defaultMultiStyle(newTopListAdapter)
            addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        }
    }

    override fun initVVMObserver() {

    }

    override fun initViewModelBindValue() {
        binding.newTopListViewModel = viewModel
    }

}

