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
        //把 response body 转为string
        var response = value.string()
        if (response.isBlank()) {
            response = "{\n" +
                    "    \"name\": \"BeJson\",\n" +
                    "    \"url\": \"http://www.bejson.com\",\n" +
                    "    \"page\": 88,\n" +
                    "    \"isNonProfit\": true,\n" +
                    "    \"address\": {\n" +
                    "        \"street\": \"科技园路.\",\n" +
                    "        \"city\": \"江苏苏州\",\n" +
                    "        \"country\": \"中国\"\n" +
                    "    },\n" +
                    "    \"links\": [\n" +
                    "        {\n" +
                    "            \"name\": \"Google\",\n" +
                    "            \"url\": \"http://www.google.com\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"name\": \"Baidu\",\n" +
                    "            \"url\": \"http://www.baidu.com\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"name\": \"SoSo\",\n" +
                    "            \"url\": \"http://www.SoSo.com\"\n" +
                    "        }\n" +
                    "    ]\n" +
                    "}"
        }
//        val baseResponse = gson.fromJson(response, BaseResponse::class.java)
////        // 这里只是为了检测code是否!=1,所以只解析HttpStatus中的字段,因为只要code和message就可以了
////        if (baseResponse.getState() !== 1) {
////            value.close()
////            throw ApiException(baseResponse.getMsg())
////        }
        return try {
            adapter.fromJson(response)
        } finally {
            value.close()
        }
    }


}