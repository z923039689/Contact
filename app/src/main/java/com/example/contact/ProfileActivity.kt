package com.example.contact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toolbar

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        //set action bar
        val actionbar = supportActionBar
        //set title for action bar
        actionbar!!.title = "User Info"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        //get name and the phone number from the last activity
        val username = intent.getStringExtra("NAME")
        val phonenumber = intent.getStringExtra("PHONENUMBER")
        //set the content of the textview
        val current_username = findViewById<TextView>(R.id.username).apply {
            text = username
        }
        val current_phonenumber = findViewById<TextView>(R.id.phonenumber).apply {
            text = phonenumber
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}