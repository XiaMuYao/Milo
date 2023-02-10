package com.confluence.milo.model

import com.confluence.milo.model.bean.Friend
import com.confluence.milo.model.databse.User
import com.confluence.milo.model.databse.UserDao
import com.confluence.milobox.base.BaseResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
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
        return remoteUserSource.getFriendWeb()
    }

    suspend fun getBanner() = remoteUserSource.getBanner()

    suspend fun getAsyncBanner() = withContext(Dispatchers.IO) {
        val data1 = async { remoteUserSource.getBanner() }
        val data2 = async { remoteUserSource.getFriendWeb() }
        return@withContext data1.await().data + data2.await().data
    }

    suspend fun getUserData(): List<User> {
        return userDao.getAll()
    }

    suspend fun saveUserData() {
        userDao.insertAll(User(uid = System.currentTimeMillis().toInt(), firstName = "xia", lastName = "muyao"))
    }

    suspend fun getFlowData() = flow {
        emit(getBanner())
        delay(5 * 1000)
        emit(getUserData())
    }
}