package com.confluence.milobox.base

data class BaseResponse<T>(val errorCode: Int, val errorMsg: String, val data: T)