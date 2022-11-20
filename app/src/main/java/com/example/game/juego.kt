package com.example.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.EditText
import android.widget.TextView

class juego : AppCompatActivity() {
    var puntos:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)
        var titulo:TextView=findViewById(R.id.nombreu) as TextView
        var intencion=intent
        val re:String? = intencion.getStringExtra("entrada")
        titulo.text=re
        puntos=0

        var tie:TextView=findViewById(R.id.tiempo) as TextView
        object :CountDownTimer(10000,1000){
            override fun onFinish() {
                tie.text="Se acabo el tiempo"
            }

            override fun onTick(p0: Long) {
                tie.text="Tiempo: " + p0/1000
            }
        }.start()
    }
    fun puntos(view: View){
       puntos ++
        var pun:TextView=findViewById(R.id.puntajeu) as TextView
        pun.text="Puntos: "+puntos.toString()

    }
}