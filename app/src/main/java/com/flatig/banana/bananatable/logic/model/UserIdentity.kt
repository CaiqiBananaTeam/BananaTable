package com.flatig.banana.bananatable.logic.model

data class UserIdentity(
    val userName: String, val userSno: String,
    val userCollege: String, val userClass: String
)

data class UserLoginMark(val userLogin: String, val userPasswd: String)
