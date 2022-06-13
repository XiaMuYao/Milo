package com.confluence.milo

import com.confluence.milobox.BaseResponse

/**
 * ================================================
 * 介    绍：
 * ================================================
 */
class MainRepository {

    suspend fun getUserList(): BaseResponse<List<String>> {
        return BaseResponse(0, "0", listOf("1", "2", "3", "4", "5"))
    }

}