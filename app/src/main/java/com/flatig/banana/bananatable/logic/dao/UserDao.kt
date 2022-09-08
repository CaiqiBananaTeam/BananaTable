package com.flatig.banana.bananatable.logic.dao

import android.content.Context
import androidx.core.content.edit
import com.flatig.banana.bananatable.TableApplication
import com.flatig.banana.bananatable.logic.model.UserIdentity
import com.flatig.banana.bananatable.logic.model.UserLoginMark

object UserDao {
    private const val login_name = "user_login"
    private const val login_passwd = "user_passwd"
    private const val user_name = "user_name"
    private const val user_sno = "user_sno"
    private const val user_college = "user_college"
    private const val user_class = "user_class"

    private fun sharedPreference() =
        TableApplication.context.getSharedPreferences("banana_table", Context.MODE_PRIVATE)

    fun saveUserMark(userMark: UserLoginMark) {
        sharedPreference().edit {
            putString(login_name, userMark.userLogin)
            putString(login_passwd, userMark.userPasswd)
        }
    }

    fun readUserMark(): UserLoginMark {
        return UserLoginMark(
            sharedPreference().getString(login_name, "Null").toString(),
            sharedPreference().getString(login_passwd, "Null").toString()
        )
    }

    fun saveUserInfo(userInfo: UserIdentity) {
        sharedPreference().edit {
            putString(user_name, userInfo.userName)
            putString(user_sno, userInfo.userSno)
            putString(user_college, userInfo.userCollege)
            putString(user_class, userInfo.userClass)
        }
    }

    fun readUserInfo(): UserIdentity {
        return UserIdentity(
            sharedPreference().getString(user_name, "Null").toString(),
            sharedPreference().getString(user_sno, "Null").toString(),
            sharedPreference().getString(user_college, "Null").toString(),
            sharedPreference().getString(user_class, "Null").toString()
        )
    }

}