package com.example.game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val compartido=this.getSharedPreferences("com.example.game", android.content.Context.MODE_PRIVATE)
        compartido.edit().putInt("maximo", 0).apply()
    }
    fun cambiarventana(view: View){
        val edd:EditText=findViewById(R.id.edad) as EditText
        var ne:Int=edd.text.toString().toInt()
       if(ne>5) {
           val inte = Intent(applicationContext, juego::class.java)
           val nombre: EditText = findViewById(R.id.nombre) as EditText

           inte.putExtra("entrada", nombre.text.toString())
           inte.putExtra("edad", edd.text.toString())
           startActivity(inte)
       } else{
           Toast.makeText(applicationContext,"Usted debe tener una edad superior a 5.", Toast.LENGTH_SHORT).show()
       }
    }
}