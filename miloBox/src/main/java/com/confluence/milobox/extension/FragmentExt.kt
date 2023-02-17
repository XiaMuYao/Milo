package com.confluence.milobox.extension

/**
 * ================================================
 * 介    绍：
 * ================================================
 */
inline fun <T> Fragment.lazyArgument(key: String) = lazy {
    arguments?.get(key)
}

inline fun <T> Fragment.lazyArgument(key: String, defaultValue: T) = lazy {
    arguments?.get(key) as? T ?: defaultValue
}

inline fun <T> Fragment.intentExtra(key: String) = lazy {
    activity?.intent?.extras?.get(key)
}

inline fun <T> Fragment.intentExtra(key: String, defaultValue: T) = lazy {
    activity?.intent?.extras?.get(key) as? T ?: defaultValue
}
