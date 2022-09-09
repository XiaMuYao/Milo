package com.confluence.milo.model

import com.confluence.milobox.base.BaseResponse

/**
 * ================================================
 * 介    绍：
 * ================================================
 */
class MainRepository(var remoteUserSource: RemoteUserSource) {

    suspend fun getUserList(): BaseResponse<String> {
        return remoteUserSource.getUserList()
    }

    suspend fun getBanner() = remoteUserSource.getBanner()

}