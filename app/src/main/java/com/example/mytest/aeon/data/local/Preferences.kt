package com.example.mytest.aeon.data.local

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class Preferences @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val sharedPreferences =
        context.getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)

    fun saveToken(login: String?) {
        sharedPreferences.edit().putString("token", login)
    }

    fun getSavedToken(): String? {
        return sharedPreferences.getString("token", null)
    }

    fun clearPreferences() {
        sharedPreferences.edit().remove("token")
    }
}