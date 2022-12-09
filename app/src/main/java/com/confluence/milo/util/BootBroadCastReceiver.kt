package com.confluence.milo.util

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.confluence.milo.MiloApplication
import com.confluence.milobox.utils.LL

class BootBroadCastReceiver : BroadcastReceiver() {

    private val ACTION_BOOT = "android.intent.action.BOOT_COMPLETED"

    override fun onReceive(context: Context, intent: Intent) {
        if (ACTION_BOOT == intent.action) {
            LL.d("restart:${MiloApplication.instance().packageName}")
            Toast.makeText(context, "restart:${MiloApplication.instance().packageName}", Toast.LENGTH_SHORT).show()
        }
    }
}