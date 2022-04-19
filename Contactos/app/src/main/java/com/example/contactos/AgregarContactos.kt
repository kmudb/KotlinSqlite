package com.example.contactos

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_agregar_contactos.*


class AgregarContactos : AppCompatActivity() {
    //2
val contactoAdmin = AdminContactos()
    //1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_contactos)
        //2
        guardarContacto_click()
    }
    //2
    fun guardarContacto_click(){
        btnGuardar.setOnClickListener {
            val nom: String = txtNombre.getText().toString()
            val num: String = txtNumero.getText().toString()
            val enc: String = txtEncargado.getText().toString()
//            Toast.makeText(AppContactos.CONTEXT,nom,Toast.LENGTH_SHORT).show()
            val newcontacto= Contacto(0,nom,enc,num)
            contactoAdmin.addContacto(newcontacto)
            //AppContactos.CONTEXT.deleteDatabase(AppContactos.DB_NAME)
            finish()
        }
    }
}