package com.confluence.milo.view

import android.app.PendingIntent
import android.content.Intent
import android.content.IntentFilter
import android.nfc.NfcAdapter
import android.widget.Toast
import com.confluence.milo.databinding.ActivityNfcBinding
import com.confluence.milo.viewmodel.NFCViewModel
import com.confluence.milobox.LL
import com.confluence.milobox.base.BaseActivity
import com.confluence.milobox.viewBinding
import com.zhengsr.nfclib.NfcType
import com.zhengsr.nfclib.ZNfc
import org.koin.androidx.viewmodel.ext.android.viewModel


class NFCActivity : BaseActivity() {
    override val viewModel: NFCViewModel by viewModel()
    override val binding by viewBinding(ActivityNfcBinding::inflate)
    private val nfcAdapter: NfcAdapter? by lazy { NfcAdapter.getDefaultAdapter(this) }
    private val mPendingIntent by lazy { PendingIntent.getActivity(this, 0, Intent(this, javaClass), 0) }


    override fun initView() {
        if (nfcAdapter == null) {
            Toast.makeText(this, "该设备不支持nfc", Toast.LENGTH_SHORT).show()
            finish()
            return
        }
        if (nfcAdapter?.isEnabled == false) {
            startActivity(Intent("android.settings.NFC_SETTINGS"));
            Toast.makeText(this, "设备未开启nfc", Toast.LENGTH_SHORT).show()
        }
    }

    override fun initVVMObserver() {
    }

    override fun initViewModelBindValue() {
    }

    override fun onResume() {
        super.onResume()
        //一旦截获NFC消息，就会通过PendingIntent调用窗口
        val pendingIntent = PendingIntent.getActivity(this, 0, Intent(this, javaClass).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0)
        val intentFilters = arrayOf<IntentFilter>()
        //用于打开前台调度（拥有最高的权限），当这个Activity位于前台（前台进程），即可调用这个方法开启前台调度
        nfcAdapter?.enableForegroundDispatch(this, pendingIntent, intentFilters, null)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        ZNfc.inject(intent!!)

        if (ZNfc.getType() == NfcType.EDEF) {

            val delegate = ZNfc.getNDEFDelegate()
            LL.d("卡ID: ${delegate.getCardId()}")

            val data = delegate.readRecord()
            data?.let {
                LL.d("数据内容: ${it.msg}")
                binding.cardContentTv.text=it.msg
            }
        }
    }


    override fun onPause() {
        super.onPause()
        if (nfcAdapter != null) {
            nfcAdapter?.disableForegroundDispatch(this)
        }
    }

}