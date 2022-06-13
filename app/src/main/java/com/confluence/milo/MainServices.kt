package com.confluence.milo

import com.confluence.milobox.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * ================================================
 * 介    绍：
 * ================================================
 */
interface MainServices {

    @GET("common/userList")
    suspend fun getUserList(@Query("userId") userId: String): BaseResponse<String>

}