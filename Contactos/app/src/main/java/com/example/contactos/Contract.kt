package com.example.contactos

import android.provider.BaseColumns
import java.util.*

class Contract {
    //definimos los campos de la tabla
    class Contacto:BaseColumns{
        companion object{
            val ID="id"
            val NOMBRE="nombre"
            val ENCARGADO="encargado"
            val NUMERO="numero"
        }
    }


}