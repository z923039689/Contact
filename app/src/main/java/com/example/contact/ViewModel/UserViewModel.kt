package com.example.contact.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.contact.Database.UserDatabase
import com.example.contact.Model.User
import com.example.contact.Repository.ContactRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {
    val readAllUser: LiveData<List<User>>
    val repository: ContactRepository

    init {
        val userDAO = UserDatabase.getDatabase(application).userDao()
        repository = ContactRepository(userDAO)
        readAllUser = repository.readAllUser
    }

    fun addUser(user: User){
        //run this scope in the background thread
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

}