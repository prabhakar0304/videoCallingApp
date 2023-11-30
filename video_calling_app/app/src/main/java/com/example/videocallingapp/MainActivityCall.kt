package com.example.videocallingapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.videocallingapp.R
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize

class MainActivityCall : AppCompatActivity()  {
    private val permissions = arrayOf(Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO)
    private val requestcode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_call)

        if (!isPermissionGranted()) {
            askPermissions()
        }

        Firebase.initialize(this)

        val LoginBtn : Button = findViewById(R.id.loginBtn)
        val UsernameEdit : EditText = findViewById(R.id.usernameEdit)

        LoginBtn.setOnClickListener {
            val username = UsernameEdit.text.toString()
            val intent = Intent(this, CallActivity::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
        }

    }

    private fun askPermissions() {
        ActivityCompat.requestPermissions(this, permissions, requestcode)
    }

    private fun isPermissionGranted(): Boolean {

        permissions.forEach {
            if (ActivityCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED)
                return false
        }
        return true
    }
}