package com.confluence.milobox.extension

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.confluence.milobox.base.BaseFragment

inline fun <T : ViewBinding> Activity.viewBinding(crossinline inflate: (LayoutInflater) -> T) = lazy { inflate(layoutInflater) }

inline fun <T : ViewBinding> BaseFragment.viewBinding(
    crossinline inflate: (LayoutInflater, ViewGroup?, Boolean) -> T,
): T {
    val binding = inflate(layoutInflater, container, false)
    container = null
    return binding
}