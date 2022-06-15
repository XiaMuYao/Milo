package com.confluence.milobox.adapter

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class BaseViewPagerAdapter(fm: FragmentActivity, private val fragmentList: MutableList<Fragment>) :
    FragmentStateAdapter(fm) {

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

}

//class  BaseViewPagerAdapter(fm: FragmentManager, private val fragmentList: MutableList<Fragment>) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
//
//    override fun getItem(position: Int): Fragment {
//        return fragmentList[position]
//    }
//
//    override fun getCount(): Int {
//        return fragmentList.size
//    }
//
//}
