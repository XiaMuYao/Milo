package com.confluence.milo.factory

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import okhttp3.ResponseBody
import retrofit2.Converter


class CustomizeGsonResponseBodyConverter<T> internal constructor(
    private val gson: Gson,
    private val adapter: TypeAdapter<T>,
) : Converter<ResponseBody, T> {
    override fun convert(value: ResponseBody): T? {
        val response = value.string()
        return adapter.fromJson(response)
    }


}