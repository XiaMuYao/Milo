package com.confluence.milobox.extension

inline fun <T> Activity.lazyIntentExtra(key: String) = lazy {
    intent.extras?.get(key) as? T ?: null
}

inline fun <T> Activity.lazyIntentExtra(key: String, defaultValue: T) = lazy {
    intent.extras?.get(key, defaultValue) ?: defaultValue
}