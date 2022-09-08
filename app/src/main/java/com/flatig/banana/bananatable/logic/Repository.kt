package com.flatig.banana.bananatable.logic

import com.flatig.banana.bananatable.logic.dao.ConfigDao
import com.flatig.banana.bananatable.logic.dao.UserDao
import com.flatig.banana.bananatable.logic.model.UserIdPattern
import com.flatig.banana.bananatable.logic.model.UserIdentity
import com.flatig.banana.bananatable.logic.model.UserLoginMark
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

object Repository {


    /**
     * Functions to return and set
     * userId Pattern
     * which is to set parser rules
     */
    fun saveUserIdPattern(pattern: UserIdPattern) = flow<UserIdPattern> {
        ConfigDao.saveUserIdPattern(pattern)
    }.flowOn(Dispatchers.IO)

    fun readUserIdPattern(): Flow<UserIdPattern> = flow {
        emit(ConfigDao.readUserIdPattern())
    }.flowOn(Dispatchers.IO)


    /**
     * Functions to return and set
     * - username and password
     *   that used to login
     *
     * - userinfo
     *   that used to show
     *   univ, college and class
     */
    fun saveUserMark(userMark: UserLoginMark) = flow<UserLoginMark> {
        UserDao.saveUserMark(userMark)
    }.flowOn(Dispatchers.IO)

    fun readUserMark(): Flow<UserLoginMark> = flow<UserLoginMark> {
        emit(UserDao.readUserMark())
    }.flowOn(Dispatchers.IO)

    fun saveUserInfo(userInfo: UserIdentity) = flow<UserIdentity> {
        UserDao.saveUserInfo(userInfo)
    }.flowOn(Dispatchers.IO)

    fun readUserInfo(): Flow<UserIdentity> = flow<UserIdentity> {
        emit(UserDao.readUserInfo())
    }.flowOn(Dispatchers.IO)

}