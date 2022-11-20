package com.example.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random


class juego : AppCompatActivity() {
    var puntos:Int=0
    var arregloimagen= ArrayList<ImageView>()
    var runn:Runnable= Runnable {}
    var handler= Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)
        var titulo:TextView=findViewById(R.id.nombreu) as TextView
        var ima1:ImageView=findViewById(R.id.imageView13) as ImageView
        var ima2:ImageView=findViewById(R.id.imageView14) as ImageView
        var ima3:ImageView=findViewById(R.id.imageView15) as ImageView
        var ima4:ImageView=findViewById(R.id.imageView16) as ImageView
        var ima5:ImageView=findViewById(R.id.imageView17) as ImageView
        var ima6:ImageView=findViewById(R.id.imageView18) as ImageView
        var ima7:ImageView=findViewById(R.id.imageView19) as ImageView
        var ima8:ImageView=findViewById(R.id.imageView20) as ImageView
        var ima9:ImageView=findViewById(R.id.imageView21) as ImageView
        var ima10:ImageView=findViewById(R.id.imageView22) as ImageView
        var ima11:ImageView=findViewById(R.id.imageView23) as ImageView
        var ima12:ImageView=findViewById(R.id.imageView24) as ImageView
        var ima13:ImageView=findViewById(R.id.imageView25) as ImageView
        var ima14:ImageView=findViewById(R.id.imageView26) as ImageView
        var ima15:ImageView=findViewById(R.id.imageView27) as ImageView
        var ima16:ImageView=findViewById(R.id.imageView28) as ImageView
        val compartido=this.getSharedPreferences("com.example.game", android.content.Context.MODE_PRIVATE)
        var final=compartido.getInt("maximo",0)

        arregloimagen= arrayListOf(ima1,ima2,ima3,ima4,ima5,ima6,ima7,ima8,ima9,ima10,ima11,ima12,ima13,ima14,ima15,ima16,)


        var intencion=intent
        val re:String? = intencion.getStringExtra("entrada")
        titulo.text=re
        puntos=0

        var tie:TextView=findViewById(R.id.tiempo) as TextView
        var max:TextView=findViewById(R.id.maximo) as TextView
        max.text=final.toString()

        ocultar()
        object :CountDownTimer(10000,1000){
            override fun onFinish() {
                compartido.edit().putInt("maximo", puntos).apply()
                handler.removeCallbacks(runn)
                for (ima in arregloimagen){
                    ima.visibility=View.INVISIBLE
                }
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

    fun ocultar(){

        runn=object :Runnable{
            override fun run() {
                for (ima in arregloimagen){
                    ima.visibility=View.INVISIBLE
                }
                val random= java.util.Random()
                val indice = random.nextInt(15-0)
                arregloimagen[indice].visibility=View.VISIBLE
                handler.postDelayed(runn, 500)
            }
        }
        handler.post(runn)
    }
}