package com.confluence.milo

import android.app.Application
import kotlin.properties.Delegates

/**
 * ================================================
 * 介    绍：
 * ================================================
 */
class MiloApplication : Application() {
    companion object {
        private var instance: MiloApplication by Delegates.notNull()
        fun instance() = instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}