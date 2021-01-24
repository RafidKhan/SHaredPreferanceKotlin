package com.example.sharedpreferancekotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var nameEt2: String = etName2.text.toString().trim()
        var passEt2: String = etPass2.text.toString().trim()


        val sharedPreferences = getSharedPreferences("KotlinSP", Context.MODE_PRIVATE)
        val savedName = sharedPreferences.getString("nameStore", null)
        val savedPass = sharedPreferences.getString("passStore", null)
        val userStatusCheck = sharedPreferences.getBoolean("userStatus", false)



        btnlogin.setOnClickListener {

                if(userStatusCheck == true)
                {
                    Toast.makeText(applicationContext, "Login Successful", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                }
            else
                {
                    Toast.makeText(applicationContext,"Login Denied", Toast.LENGTH_SHORT).show()
                }



        }

//        btnBackToReg.setOnClickListener {
//            val intent = Intent(this, RegisterActivity::class.java)
//            startActivity(intent)
//        }
    }

    private fun loadData()
    {
        val sharedPreferences = getSharedPreferences("KotlinSP", Context.MODE_PRIVATE)
        val savedName = sharedPreferences.getString("nameStore", null)
        val savedPass = sharedPreferences.getString("passStore", null)
        val userStatusCheck = sharedPreferences.getBoolean("userStatus", false)

        if(userStatusCheck == true)
        {
            Toast.makeText(applicationContext, "Login Successful", Toast.LENGTH_LONG).show()
        }
    }
}