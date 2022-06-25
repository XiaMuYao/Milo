package com.confluence.milo

import android.app.AlertDialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.widget.Toast


/**
 * ================================================
 * 介    绍：
 * ================================================
 */
object Util {

    fun showDialog(
        context: Context,
        message: String,
    ) {
        val dialog: AlertDialog = AlertDialog.Builder(context)
            .setTitle("生成结果")
            .setMessage(message)
            .setNegativeButton("取消") { dialog, _ ->
                dialog.dismiss()
            }
            .setPositiveButton("复制内容") { dialog, _ ->
                val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager?
                val clipData = ClipData.newPlainText(null, message)
                clipboard!!.setPrimaryClip(clipData)
                Toast.makeText(context, "复制成功！", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }.create()

        dialog.show()
    }


    fun startApp(
        context: Context, packageName: String
    ) {
        try {
            val intent: Intent = context.packageManager.getLaunchIntentForPackage(packageName) as Intent
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "启动失败 App不存在或者其他异常！", Toast.LENGTH_SHORT).show()
        }
    }

    fun showHelpDialog(
        context: Context,
        title: String,
        message: String
    ) {
        val dialog: AlertDialog = AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(message)
            .setNegativeButton("取消") { dialog, _ ->
                dialog.dismiss()
            }
            .setPositiveButton("好的") { dialog, _ ->
                dialog.dismiss()
            }.create()

        dialog.show()
    }
}