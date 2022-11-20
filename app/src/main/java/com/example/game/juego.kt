package com.example.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class juego : AppCompatActivity() {
    var puntos:Int
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)
        var titulo:TextView=findViewById(R.id.nombreu) as TextView
        var intencion=intent
        val re:String? = intencion.getStringExtra("entrada")
        titulo.text=re
    }
    fun puntos(view: View){

    }
}