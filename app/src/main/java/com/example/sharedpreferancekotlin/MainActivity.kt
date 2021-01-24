package com.example.sharedpreferancekotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val sharedPreferences = getSharedPreferences("KotlinSP", Context.MODE_PRIVATE)
        val savedName = sharedPreferences.getString("nameStore", null)
        val savedPass = sharedPreferences.getString("passStore", null)
        val userStatusCheck = sharedPreferences.getBoolean("userStatus", false)



        btnContinue.setOnClickListener {

            if(userStatusCheck== true) {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
            else
            {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
