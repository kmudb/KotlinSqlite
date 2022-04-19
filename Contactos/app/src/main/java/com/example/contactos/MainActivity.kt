package com.example.contactos

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val contactoAdmin = AdminContactos()
    lateinit var nombres:ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        eliminar()
    }

    override fun onStart() {
        super.onStart()
        crearLista()
    }

    override fun onResume(){
        super.onResume()
        //crearLista()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate=menuInflater
        inflate.inflate(R.menu.menu_principal,menu)
        return true
    }

    fun crearLista(){
        nombres = contactoAdmin.getAllContactos()!!
        val adaptador=ArrayAdapter(AppContactos.CONTEXT,android.R.layout.simple_list_item_1,nombres!!)
        ListContactos.adapter= adaptador
        //al seleccionar un elemento de la liswta
        ListContactos.onItemClickListener=AdapterView.OnItemClickListener{adapterView, view, i, l ->
            val item=nombres!!.get(i)
            Toast.makeText(AppContactos.CONTEXT,item,Toast.LENGTH_SHORT).show()
        }
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item!!.itemId){
            R.id.action_add->{
                val intentAdd= Intent(applicationContext,AgregarContactos::class.java)
                startActivity(intentAdd)
                return true
            }else-> return super.onOptionsItemSelected(item)

        }
    }

    fun eliminar(){
        ListContactos.onItemLongClickListener= AdapterView.OnItemLongClickListener { adapterView, view, i, l ->

            val nombre = nombres.get(i)

            val Dialog = AlertDialog.Builder(this)
            Dialog.setTitle("Confirmación")
            Dialog.setMessage("Confirme que desea eliminar este contacto")
            Dialog.setPositiveButton("Si"){dialogInterface, i->
                //TODO -Aqui programamos lo que queremos que pase cuando oprima si
                contactoAdmin.deleteContacto(nombre)
                crearLista()
            }
            Dialog.setNegativeButton("No"){dialogInterface,i->
                dialogInterface.dismiss()
            }
            Dialog.show()
            true
        }
    }
}