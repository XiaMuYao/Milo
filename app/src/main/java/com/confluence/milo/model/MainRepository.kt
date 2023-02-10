package com.confluence.milo.model

import com.confluence.milo.model.bean.Friend
import com.confluence.milobox.base.BaseResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * ================================================
 * 介    绍：
 * ================================================
 */
class MainRepository @Inject constructor(private var remoteUserSource: RemoteUserSource) {

    suspend fun friendWeb(): BaseResponse<List<Friend>> {
        return remoteUserSource.getFriendWeb()
    }

    suspend fun getBanner() = remoteUserSource.getBanner()

    suspend fun getAsyncBanner() = withContext(Dispatchers.IO) {
        val data1 = async { remoteUserSource.getBanner() }
        val data2 = async { remoteUserSource.getFriendWeb() }
        return@withContext data1.await().data + data2.await().data
    }


}