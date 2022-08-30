package com.confluence.milo

import android.app.Application
import com.confluence.milo.constant.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent
import org.koin.core.context.GlobalContext.startKoin
import kotlin.properties.Delegates

/**
 * ================================================
 * 介    绍：
 * ================================================
 */
class MiloApplication : Application(), KoinComponent {

    companion object {
        private var instance: MiloApplication by Delegates.notNull()
        fun instance() = instance
    }

    override fun onCreate() {
        super.onCreate()
        instance  = this

        startKoin {
            androidLogger()
            androidContext(this@MiloApplication)
            modules(appModule)
        }

    }
}