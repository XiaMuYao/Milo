package com.confluence.milobox

import android.app.Application

/**
 * ================================================
 * 介    绍：
 * ================================================
 */
object MiloBoxApplication {
    lateinit var application: Application

    fun init(application: Application) {
        this.application = application
    }
}