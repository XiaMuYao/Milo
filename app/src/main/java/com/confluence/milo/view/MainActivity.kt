package com.confluence.milo.view

import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.confluence.milo.R
import com.confluence.milo.Util
import com.confluence.milo.databinding.ActivityMainBinding
import com.confluence.milo.viewmodel.MainViewModel
import com.confluence.milobox.base.BaseActivity
import com.confluence.milobox.viewBinding
import com.gyf.immersionbar.ImmersionBar
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : BaseActivity() {

    override val viewModel: MainViewModel by viewModel()
    override val binding by viewBinding(ActivityMainBinding::inflate)

    override fun setImmersionBar() {
        ImmersionBar.with(this)
            .barColor(R.color.white)
            .fitsSystemWindows(true)
            .init()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> {
                Util.showHelpDialog(this, title = "关于软件", getString(R.string.about))
                true
            }
            R.id.action_help -> {
                Util.showHelpDialog(this, title = "使用帮助", getString(R.string.help))
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun initView() {
        setSupportActionBar(binding.appBarMain.toolbar.apply {
            title = "板块发帖助手"
            navigationIcon = getDrawable(R.drawable.icon_menu)
        })
        binding.appBarMain.toolbar.setNavigationOnClickListener {
            binding.drawerLayout.openDrawer(binding.navView)
        }
        binding.navView.setNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.action_about -> {
                    Util.showHelpDialog(this, title = "关于软件", getString(R.string.about))
                }
                R.id.action_help -> {
                    Util.showHelpDialog(this, title = "使用帮助", getString(R.string.help))
                }
            }
            binding.drawerLayout.close()
            false
        }
        binding.appBarMain.softwareBtn.setOnClickListener { UtilitySoftwareActivity.start(this@MainActivity) }
        binding.appBarMain.originBtn.setOnClickListener { OriginalActivity.start(this@MainActivity) }
        binding.appBarMain.gameBtn.setOnClickListener { GameActivity.start(this@MainActivity) }
        binding.appBarMain.moreBtn.setOnClickListener { Toast.makeText(this@MainActivity, "更多发帖格式可以反馈后续更新!", Toast.LENGTH_SHORT).show() }
    }

    override fun initVVMObserver() {

    }

    override fun initViewModelBindValue() {
        binding.mainViewModel = viewModel
    }
}