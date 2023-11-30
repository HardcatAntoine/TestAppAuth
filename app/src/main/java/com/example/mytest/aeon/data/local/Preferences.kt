package com.example.mytest.aeon.data.local

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class Preferences @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val sharedPreferences =
        context.getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)

    fun saveToken(token: String?) {
        sharedPreferences.edit().putString(TOKEN, token)
    }

    fun getSavedToken(): String? {
        return sharedPreferences.getString(TOKEN, null)
    }

    fun clearPreferences() {
        sharedPreferences.edit().remove(TOKEN)
    }
    companion object{
        const val TOKEN = "token"
    }
}