package com.confluence.milo.model

import com.confluence.milo.model.bean.ArticleData
import com.confluence.milo.model.bean.Banner
import com.confluence.milo.model.bean.Friend
import com.confluence.milo.model.databse.User
import com.confluence.milo.model.databse.UserDao
import com.confluence.milobox.base.BaseResponse
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * ================================================
 * 介    绍：
 * ================================================
 */
class MainRepository @Inject constructor(
    private var remoteUserSource: RemoteUserSource,
    private var userDao: UserDao,
) {

    suspend fun friendWeb(): BaseResponse<List<Friend>> {
        remoteUserSource.getBanner()
        remoteUserSource.getBanner()
        remoteUserSource.getBanner()
        remoteUserSource.getBanner()
        return remoteUserSource.getFriendWeb()
    }

    suspend fun getBanner() = remoteUserSource.getBanner()

    suspend fun getAsyncBanner() = withContext(Dispatchers.IO) {
        val list = mutableListOf<Deferred<BaseResponse<List<Banner>>>>()

        list.add(async {
            val banner = remoteUserSource.getBanner()
            banner
        })

        list.add(async {
            remoteUserSource.getBanner()
        })


        val data1 = async { remoteUserSource.getBanner() }
        val data2 = async { remoteUserSource.getFriendWeb() }
        return@withContext data1.await().data + data2.await().data


//        return@withContext list.awaitAll()
    }

    suspend fun getUserData(): List<User> {
        return userDao.getAll()
    }

    suspend fun saveUserData() {
        userDao.insertAll(
            User(
                uid = System.currentTimeMillis().toInt(),
                firstName = "xia",
                lastName = "muyao"
            )
        )
    }


    suspend fun getFlowData() = flow {
        emit(getBanner())
        emit(getUserData())
//        delay(5 * 1000)
    }


    suspend fun getAllArticle() = withContext(Dispatchers.IO) {
        val article = remoteUserSource.getArticle(1)

        val list = mutableListOf<Deferred<BaseResponse<ArticleData>>>()

        (2..100).forEach {
            list.add(
                async {
                    remoteUserSource.getArticle(it)
                }
            )
        }
        return@withContext list.awaitAll()

    }
}