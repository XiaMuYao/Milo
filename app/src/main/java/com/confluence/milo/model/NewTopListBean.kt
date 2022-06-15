package com.confluence.milo.model

/**
 * ================================================
 * 介    绍：
 * ================================================
 */
class NewTopListBean {
    var imageUrl = ""
    var userName = ""
    var createTime = ""
    var createType = ""
        get() = "·${field}"

    var title = ""
    var titleImage = ""

    var commentNum = 0
    var likeNum = 0
}