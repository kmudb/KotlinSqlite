package com.example.contactos

import android.app.Application
import android.content.Context
import android.os.Build

class AppContactos: Application() {
    //variables estaticas
    companion object{
      lateinit var CONTEXT: Context
      lateinit  var DB: InitDB
        val DB_NAME = "ContactosDB.db"
        val VERSION = 1
        val TB_CONTACTOS = "tbContactos" //Nombre de la tabla

    }

    override fun onCreate() {
        super.onCreate()
        CONTEXT = applicationContext
        DB=InitDB()
    }
}