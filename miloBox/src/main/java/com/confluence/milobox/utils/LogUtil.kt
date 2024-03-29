package com.confluence.milobox.utils

import android.util.Log
import com.confluence.milobox.BuildConfig

/**
 * ================================================
 * 创建日期： 2018/8/30
 * 描    述：日志工具
 * ================================================
 */
typealias LL = LogUtil

object LogUtil {
    private val DEBUG = BuildConfig.DEBUG

    /**
     * 类名
     */
    lateinit var className: String

    /**
     * 方法名
     */
    lateinit var methodName: String

    /**
     * 行数
     */
    var lineNumber: Int = 0

    private fun createLog(log: String): String {
        val buffer = StringBuffer()
        buffer.append("(").append(className).append(":").append(lineNumber).append(")")
        buffer.append("  打印信息==>  ")
        buffer.append(log)
        return buffer.toString()
    }

    private fun getMethodNames(sElements: Array<StackTraceElement>) {
        className = sElements[1].fileName
        methodName = sElements[1].methodName
        lineNumber = sElements[1].lineNumber
    }


    fun e(message: String) {
        if (!DEBUG)
            return

        // Throwable instance must be created before any methods
        getMethodNames(Throwable().stackTrace)
        Log.e(className, createLog(message))
    }


    fun i(message: String) {
        if (!DEBUG)
            return

        getMethodNames(Throwable().stackTrace)
        Log.i(className, createLog(message))
    }

    fun d(message: String) {
        if (!DEBUG)
            return

        getMethodNames(Throwable().stackTrace)
        Log.d(className, createLog(message))
    }

    fun v(message: String) {
        if (!DEBUG)
            return

        getMethodNames(Throwable().stackTrace)
        Log.v(className, createLog(message))
    }

    fun w(message: String) {
        if (!DEBUG)
            return

        getMethodNames(Throwable().stackTrace)
        Log.w(className, createLog(message))
    }

    fun wtf(message: String) {
        if (!DEBUG)
            return
        getMethodNames(Throwable().stackTrace)
        Log.wtf(className, createLog(message))
    }
}