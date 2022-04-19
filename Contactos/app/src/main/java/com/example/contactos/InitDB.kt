package com.example.contactos

import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase



class InitDB:SQLiteOpenHelper(AppContactos.CONTEXT, AppContactos.DB_NAME, null , AppContactos.VERSION) {
      val queryCreaTabla="CREATE TABLE ${AppContactos.TB_CONTACTOS} ("+
        "${Contract.Contacto.ID} INTEGER PRIMARY KEY AUTOINCREMENT,"+
        "${Contract.Contacto.NOMBRE} TEXT NOT NULL,"+
        "${Contract.Contacto.ENCARGADO} TEXT NOT NULL,"+
        "${Contract.Contacto.NUMERO} TEXT NOT NULL)";

    override fun onCreate(db: SQLiteDatabase?) {
       db!!.execSQL(queryCreaTabla)

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}