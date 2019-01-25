package com.example.gustavo.proyectobasico

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_imc.*
import kotlin.math.roundToInt

class imc : AppCompatActivity() {

    var flagIMC : Boolean = false
    var carita : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        btn_calcularIMC.setOnClickListener(){
            if (!et_estaturaIMC.text.isEmpty() && !et_pesoIMC.text.isEmpty()){

                val peso : Float = et_pesoIMC.text.toString().toFloat()
                val estatura : Float = et_estaturaIMC.text.toString().toFloat()

                val imcRes : Float  = peso/(estatura*estatura)
                val imcRes2: Int = imcRes.toInt()

                if (imcRes2<20){
                    carita = "triste"
                }else if(20 <= imcRes2 && imcRes2 <= 25){
                    carita = "feliz"
                }else{
                    carita = "enojado"
                }

                tv_etiquetaIMC.text = "Su IMC es:"
                tv_resultadoIMC.text =imcRes2.toString() + " [kg/m2]"

                flagIMC = true                  // Levantamos bandera para indicar que se ha calculado un IMC

                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)



            }else{
                Toast.makeText(this,"No has llenado los campos", Toast.LENGTH_SHORT).show()
            }

        }

    }

    fun regresarIMC(){
        val regIntent = Intent()
        regIntent.putExtra("reg_IMC",tv_resultadoIMC.text)
        regIntent.putExtra("emoji", carita)

        if(flagIMC){
            setResult(Activity.RESULT_OK,regIntent)
        }else{
            setResult(Activity.RESULT_CANCELED,regIntent)
        }
        finish()
    }

    override fun onBackPressed() {
        regresarIMC()
        super.onBackPressed()
    }

}
