package com.example.sharedpreferancekotlin

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

     var userStatus: Boolean = false


    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var nameEt: String = etName.text.toString().trim()
        var passEt: String = etPass.text.toString().trim()

        btnReg.setOnClickListener {

              saveData()
              userStatus = true
              Toast.makeText(applicationContext, "Registration Done", Toast.LENGTH_SHORT).show()
              val intent = Intent(this, LoginActivity::class.java)
              startActivity(intent)

        }



    }

    private fun saveData()
    {


        val nameStore = etName.text.toString()
        val passStore = etPass.text.toString()

        val sharedPreferences = getSharedPreferences("KotlinSP", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.apply()
        {
            putString("nameStore", nameStore )
            putString("passStore", passStore)
            putBoolean("userStatus", userStatus)
        }.apply()


    }

}