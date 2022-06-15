package com.confluence.milo

import android.app.Application
import com.confluence.milo.constant.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent
import org.koin.core.context.GlobalContext.startKoin

/**
 * ================================================
 * 介    绍：
 * ================================================
 */
class MiloApplication : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MiloApplication)
            modules(appModule)
        }
    }
}