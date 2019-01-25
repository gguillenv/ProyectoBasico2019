package com.example.gustavo.proyectobasico

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_calorias.*

class calorias : AppCompatActivity() {

    var flagCal : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calorias)

        btn_calCalorias.setOnClickListener(){
            if (!et_pesoCal.text.isEmpty() && !et_estaturaCal.text.isEmpty() && !et_edadCal.text.isEmpty()){

                val peso: Float = et_pesoCal.text.toString().toFloat()
                val estatura: Float = et_estaturaCal.text.toString().toFloat()
                val edad: Float = et_edadCal.text.toString().toFloat()
                var calorias: Int

                if (rb_mujeres.isChecked){
                    calorias = (655 + (9.6*peso) + (1.85*estatura) -(4.68*edad)).toInt()
                }else{
                    calorias = (66.5 + (13.75*peso) + (5*estatura) - (6.78*edad)).toInt()
                }

                tv_etiquetaCal.text="Debe Consumir"
                tv_ResultadoCal.text = calorias.toString()

                flagCal = true

                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)

            }else{
                Toast.makeText(this,"No has llenado todos los campos",Toast.LENGTH_SHORT).show()
            }


        }
    }

    fun regresarCal(){
        val regIntentC = Intent()
        regIntentC.putExtra("reg_Cal",tv_ResultadoCal.text)

        if(flagCal){
            setResult(Activity.RESULT_OK,regIntentC)
        }else{
            setResult(Activity.RESULT_CANCELED,regIntentC)
        }
        finish()
    }

    override fun onBackPressed() {
        regresarCal()
        super.onBackPressed()
    }
}
