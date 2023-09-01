package com.confluence.milo.view

import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Build
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import com.confluence.milo.databinding.ActivityMainBinding
import com.confluence.milo.viewmodel.MainViewModel
import com.confluence.milobox.adapter.BaseViewPagerAdapter
import com.confluence.milobox.base.BaseActivity
import com.confluence.milobox.extension.viewBinding
import com.confluence.milobox.utils.LL
import com.confluence.milobox.view.BaseBottomMenu
import com.confluence.milobox.view.BaseHeader
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    override val viewModel: MainViewModel by viewModels()
    override val binding by viewBinding(ActivityMainBinding::inflate)

    private val mainViewPagerAdapter =
        BaseViewPagerAdapter(this, (0..4).map { UserFragment.newInstance(it) }.toMutableList())

    @RequiresApi(Build.VERSION_CODES.O)
    override fun initView() {
        binding.ViewPager2.adapter = mainViewPagerAdapter
        binding.mainPageBottomMenuView.setCallBackAndViewPager(
            binding.ViewPager2,
            object : BaseBottomMenu.BaseBottomMenuCallBack {
                override fun menuSelectCallBack(
                    id: BaseBottomMenu.MainTabPage,
                    ordinal: Int,
                ) {

                }

                override fun onPageSelected(position: Int) {
                }
            })

        binding.mainPageHeadView.baseHeaderCallBack =
            object : BaseHeader.BaseHeaderCallBack {
                override fun leftClickCallBack() {
                    LL.d("back")
                }

                override fun rightClickCallBack() {
                    LL.d("menu")
                }
            }

        binding.button.setOnClickListener {
            viewModel.getSerialCall()
        }
        binding.button1.setOnClickListener {
            viewModel.getAsyncCall()
        }


        binding.get.setOnClickListener {
            viewModel.getUserList()
        }
        binding.save.setOnClickListener {
            viewModel.saveUserData()
        }
        binding.getFlowData.setOnClickListener {
            viewModel.getFlowData()
        }

        binding.buttonAllArticle.setOnClickListener {
//            viewModel.getAllArticleData()
            val bitmap = Bitmap.createBitmap(
                binding.buttonCl.width,
                binding.buttonCl.height,
                Bitmap.Config.ARGB_8888
            )

            val canvas = Canvas(bitmap)

            binding.imageview.draw(canvas)
            bitmap
        }
    }


    override fun initVVMObserver() {
        viewModel.flowLiveData.observe(this) {
        }
    }

    override fun initViewModelBindValue() {
        binding.mainViewModel = viewModel
    }
}
