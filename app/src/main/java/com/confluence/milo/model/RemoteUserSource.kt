package com.confluence.milo.model

import com.confluence.milobox.base.BaseResponse
import retrofit2.http.GET

/**
 * ================================================
 * 介    绍：
 * ================================================
 */
interface RemoteUserSource {

    @GET("2021072009400331.json")
    suspend fun getUserList(): BaseResponse<String>

}