package com.confluence.milo

import android.app.Application
import com.confluence.milo.constant.appModule
import com.umeng.analytics.MobclickAgent
import com.umeng.commonsdk.UMConfigure
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

        UMConfigure.init(this, "62b6a9e305844627b5c64b38", "Umeng", UMConfigure.DEVICE_TYPE_PHONE, "");
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO);


        startKoin {
            androidLogger()
            androidContext(this@MiloApplication)
            modules(appModule)
        }
    }
}