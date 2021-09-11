package com.example.acuclass.data.bd.config

import android.app.Application
import androidx.room.Room
import com.example.acuclass.data.bd.Prefs

class AcuClassApp: Application() {
    companion object{
        lateinit var db: BDAcuClass
        lateinit var prefs: Prefs
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            this,
            BDAcuClass::class.java,
            "acuclass"
        ).build()

        prefs = Prefs(applicationContext)
    }
}