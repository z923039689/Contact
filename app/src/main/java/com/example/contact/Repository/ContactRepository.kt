package com.example.contact.Repository

import androidx.lifecycle.LiveData
import com.example.contact.DAO.UserDAO
import com.example.contact.Model.User

class ContactRepository(private val userDAO: UserDAO) {

    val readAllUser: LiveData<List<User>> = userDAO.readAllUser()

    suspend fun addUser(user: User){
        userDAO.addUser(user)
    }

}