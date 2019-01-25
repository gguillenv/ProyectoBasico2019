package com.example.gustavo.proyectobasico

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_inciar.setOnClickListener(){
            val i = Intent(this,Menu::class.java)
            startActivity(i)
        }

    }
}
