package com.example.contactos

import android.database.DatabaseUtils
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
data class Contacto(var id:Int, var nombre:String, var numero:String)
class AdminContactos {
    //query para ver todos los contactos
    fun getAllContactos():ArrayList<String>?{
        try {
            val nombres= arrayListOf<String>()
            val db=AppContactos.DB.readableDatabase
            //verifica si hay datos guardados
            val numregistro= DatabaseUtils.queryNumEntries(db,AppContactos.TB_CONTACTOS).toInt()
            if(numregistro>0){
                val query="SELECT ${Contract.Contacto.NOMBRE} FROM ${AppContactos.TB_CONTACTOS}"
                val r=db.rawQuery(query,null)
                r.moveToFirst()
                do {
                    //llenar lista
                    nombres.add(r.getString(r.getColumnIndexOrThrow(Contract.Contacto.NOMBRE)))
                }while (r.moveToNext())

            }else{
                Toast.makeText(AppContactos.CONTEXT,"no hay registros", Toast.LENGTH_SHORT).show()
            }
            db.close()
            return nombres
        }catch (ex:Exception){
            Toast.makeText(AppContactos.CONTEXT,"No se recuperar contactos",Toast.LENGTH_SHORT).show()
            return null
        }
    }
    //query que permita insertar un contacto
    fun addContacto(contacto: Contacto){
        try {
            val db=AppContactos.DB.writableDatabase
            val query="INSERT INTO ${AppContactos.TB_CONTACTOS} ("+
                    "${Contract.Contacto.NOMBRE}, ${Contract.Contacto.NUMERO}) "+
                    "VALUES('${contacto.nombre}','${contacto.numero}');"
            db.execSQL(query)
            //Toast.makeText(AppContactos.CONTEXT,"Agregado",Toast.LENGTH_SHORT).show()
            db.close()

        }catch (ex:Exception){
            Toast.makeText(AppContactos.CONTEXT,"No se pudo guardar contacto",Toast.LENGTH_SHORT).show()
        }
    }

    //query eliminar contacto
    fun deleteContacto(nombre: String){
        try{
            val db = AppContactos.DB.writableDatabase
            var query="DELETE FROM ${AppContactos.TB_CONTACTOS} WHERE ${Contract.Contacto.NOMBRE}='$nombre';"
            db.execSQL(query)
            db.close()
        }catch (ex:Exception){
            Toast.makeText(AppContactos.CONTEXT,"ERROR: No se pudo agregar contacto",Toast.LENGTH_SHORT).show()
        }
    }
}