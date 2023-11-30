package com.example.mytest.aeon.data.local

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class Preferences @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val sharedPreferences =
        context.getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)

    fun saveInputLogin(login: String?) {
        sharedPreferences.edit().putString("login", login)
    }

    fun saveInputPassword(password: String?) {
        sharedPreferences.edit().putString("password", password)
    }
}