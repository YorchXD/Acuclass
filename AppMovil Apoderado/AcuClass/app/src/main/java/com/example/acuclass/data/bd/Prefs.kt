package com.example.acuclass.data.bd

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context) {
    private val PREFS_NAME = "com.example.acuclass"
    private val SHARED_EMAIL = "shared_email"
    private val SHARED_RUN_APODERADO = "shared_run_apoderado"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)

    var email: String?
            get() = prefs.getString(SHARED_EMAIL, "")
            set(value) = prefs.edit().putString(SHARED_EMAIL, value).apply()

    var runApoderado: String?
        get() = prefs.getString(SHARED_RUN_APODERADO, "")
        set(value) = prefs.edit().putString(SHARED_RUN_APODERADO, value).apply()
}

