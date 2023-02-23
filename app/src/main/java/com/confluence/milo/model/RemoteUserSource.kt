package com.confluence.milo.model

import com.confluence.milo.model.bean.ArticleData
import com.confluence.milo.model.bean.Banner
import com.confluence.milo.model.bean.Friend
import com.confluence.milobox.base.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * ================================================
 * 介    绍：
 * ================================================
 */
interface RemoteUserSource {

    /**
     * 首页banner
     */
    @GET("banner/json")
    suspend fun getBanner(): BaseResponse<List<Banner>>

    /**
     * 常用网站
     */
    @GET("friend/json")
    suspend fun getFriendWeb(): BaseResponse<List<Friend>>

    @GET("article/list/{page}/json")
    suspend fun getArticle(@Path("page") page: Int): BaseResponse<ArticleData>


}