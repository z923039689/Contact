package com.example.contact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.ViewModelProvider
import com.example.contact.Model.User
import com.example.contact.ViewModel.UserViewModel
import kotlinx.android.synthetic.main.activity_add_new_contact.*

class AddNewContactActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_contact)

        //set action bar
        val actionbar = supportActionBar
        //set title for action bar
        actionbar!!.title = "User Info"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        //set up user view model
        userViewModel = ViewModelProvider(this).get(UserViewModel(application)::class.java)

        //function for add button
        val add_button : AppCompatButton = findViewById(R.id.add_button)
        add_button.setOnClickListener{
            AddContact()
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    //function to add user to database
    private fun AddContact(){
        val username = username.text.toString()
        val phonenumber = phonenumber.text.toString()

        if (check(username, phonenumber)){
            //create user object for database
            val user = User(0, username, phonenumber)
            //add user to database
            userViewModel.addUser(user)
            Toast.makeText(this, "successfully", Toast.LENGTH_SHORT).show()
        }
    }

    private fun check(username: String, phonenumber: String): Boolean{
        return !(TextUtils.isEmpty(username) && TextUtils.isEmpty(phonenumber))
    }
}