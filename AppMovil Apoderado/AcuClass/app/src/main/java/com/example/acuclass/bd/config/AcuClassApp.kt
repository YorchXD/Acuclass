package com.example.acuclass.bd.config

import android.app.Application
import androidx.room.Room

class AcuClassApp: Application() {
    companion object{
        lateinit var db: BDAcuClass
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            this,
            BDAcuClass::class.java,
            "acuclass"
        ).build()
    }
}