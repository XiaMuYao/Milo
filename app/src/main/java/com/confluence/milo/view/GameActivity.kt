package com.confluence.milo.view

import android.content.Context
import android.content.Intent
import android.provider.Settings
import com.confluence.milo.R
import com.confluence.milo.Util
import com.confluence.milo.databinding.ActivityGameBinding
import com.confluence.milo.databinding.ActivityUtilitySoftwareBinding
import com.confluence.milo.viewmodel.MainViewModel
import com.confluence.milobox.base.BaseActivity
import com.confluence.milobox.viewBinding
import com.gyf.immersionbar.ImmersionBar
import org.koin.androidx.viewmodel.ext.android.viewModel


class GameActivity : BaseActivity() {

    override val viewModel: MainViewModel by viewModel()
    override val binding by viewBinding(ActivityGameBinding::inflate)


    companion object {
        fun start(context: Context) {
            val starter = Intent(context, GameActivity::class.java)
            // starter.putExtra()
            context.startActivity(starter)
        }
    }


    override fun setImmersionBar() {
        ImmersionBar.with(this)
            .barColor(R.color.game)
            .fitsSystemWindows(true)
            .init()
    }

    override fun initView() {
        binding.generateBtn.setOnClickListener {
            val message =
                    "【软件名称】${binding.name.text} \n" +
                    "【软件包名】${binding.packageName.text} \n" +
                    "【软件版本】${binding.version.text} \n" +
                    "【软件语言】${binding.language.text} \n" +
                    "【软件大小】${binding.size.text} \n" +
                    "【软件介绍】${binding.introduction.text} \n" +
                    "【特别说明】${binding.description.text} \n" +
                    "【下载地址】${binding.address.text} \n" +
                    "\n" +
                    "====================================\n" +
                    "点赞+评论+关注\n" +
                    "喜欢就打赏支持一下"

            Util.showDialog(this, message)
        }
        binding.softwareMessage.setOnClickListener {
            val intent = Intent(Settings.ACTION_MANAGE_ALL_APPLICATIONS_SETTINGS)
            this.startActivity(intent)
        }
        binding.startApp.setOnClickListener {
            Util.startApp(this,"com.upgadata.up7723")
        }
        binding.back.setOnClickListener { finish() }
    }

    override fun initVVMObserver() {

    }

    override fun initViewModelBindValue() {
    }
}