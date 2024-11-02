package com.example.umxplore.helper

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class SharedPref(activity: Activity) {

    private val login = "login"
    private val mypref = "MAIN_PRF"
    private val sp: SharedPreferences

    init {
        // Menggunakan getSharedPreferences() untuk menentukan nama preference dan mode
        sp = activity.getSharedPreferences(mypref, Context.MODE_PRIVATE)
    }

    fun setStatusLogin(status: Boolean) {
        sp.edit().putBoolean(login, status).apply()
    }

    fun getStatusLogin(): Boolean {
        return sp.getBoolean(login, false)
    }
}
