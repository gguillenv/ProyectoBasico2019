package com.example.gustavo.proyectobasico

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_recetas.*

class recetas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recetas)

        btn_desayunosR.setOnClickListener(){
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://laverdadnoticias.com/estiloyvida/Las-mejores-6-recetas-de-desayunos-saludables-20180818-0009.html")))
        }
        btn_comidasR.setOnClickListener(){
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://www.objetivobienestar.com/10-comidas-sanas-que-se-preparan-en-15-minutos_10541_102.html")))
        }
        btn_cenasR.setOnClickListener(){
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://www.objetivobienestar.com/cenas-saludables-en-10-minutos_11707_102.html")))
        }
    }
}
