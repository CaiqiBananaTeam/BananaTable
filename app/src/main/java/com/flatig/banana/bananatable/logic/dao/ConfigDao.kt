package com.flatig.banana.bananatable.logic.dao

import android.content.Context
import androidx.core.content.edit
import com.flatig.banana.bananatable.TableApplication
import com.flatig.banana.bananatable.logic.model.UserIdPattern

object ConfigDao {
    private const val address_login = "address_login"
    private const val address_info = "address_info"

    private fun sharedPreference() =
        TableApplication.context.getSharedPreferences("banana_table", Context.MODE_PRIVATE)

    fun saveUserIdPattern(pattern: UserIdPattern) {
        sharedPreference().edit {
            putString(address_login, pattern.addressLogin)
            putString(address_info, pattern.addressInfo)
        }
    }

    fun readUserIdPattern(): UserIdPattern {
        return UserIdPattern(
            sharedPreference().getString(address_login, "Null").toString(),
            sharedPreference().getString(address_info, "Null").toString()
        )
    }

}