package com.example.gustavo.proyectobasico

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.TypedValue
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_menu.*

class Menu : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        vc_IMC.setOnClickListener(){
            val i = Intent (this,imc::class.java)
            startActivityForResult(i,1)
        }

        vc_piramide.setOnClickListener(){
            val i = Intent (this,piramide::class.java)
            startActivity(i)
        }

        vc_calorias.setOnClickListener(){
            val i = Intent (this, calorias::class.java)
            startActivityForResult(i,2)
        }

        vc_recetas.setOnClickListener(){
            val i = Intent (this,recetas::class.java)
            startActivity(i)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == Activity.RESULT_OK){
            val etiqueta_IMC = data?.getStringExtra("reg_IMC")
            val carita_IMC = data?.getStringExtra("emoji")
            tv_etiqueta_IMC.text = "IMC Calculado: " + etiqueta_IMC.toString()

            when(carita_IMC){
                "triste" -> {
                        tv_estado.text = "TRISTE"
                        iv_emoji_Menu.setImageDrawable(
                            ContextCompat.getDrawable(applicationContext, R.drawable.triste)
                        )
                }
                "feliz"-> {
                        tv_estado.text = "FELIZ!!"
                        iv_emoji_Menu.setImageDrawable(
                            ContextCompat.getDrawable(applicationContext, R.drawable.happy)
                        )
                }
                "enojado"-> {
                        tv_estado.text = "FURIOSO"
                        iv_emoji_Menu.setImageDrawable(
                            ContextCompat.getDrawable(applicationContext, R.drawable.enojado)
                        )
                }
            }
        }
        if (requestCode == 2 && resultCode == Activity.RESULT_OK){
            val etiqueta_Cal = data?.getStringExtra("reg_Cal")
            tv_etiqueta_Cal.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18F)
            tv_etiqueta_Cal.text = "Calorias Recomendadas"+ etiqueta_Cal.toString()
        }
    }

}
