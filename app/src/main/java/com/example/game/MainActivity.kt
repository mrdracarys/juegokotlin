package com.example.game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun cambiarventana(view: View){
        val inte=Intent(applicationContext,juego::class.java)
        val nombre:EditText=findViewById(R.id.nombre) as EditText
        val edd:EditText=findViewById(R.id.edad) as EditText
        inte.putExtra("entrada",nombre.text.toString())
        inte.putExtra("edad",edd.text.toString())
        startActivity(inte)
    }
}