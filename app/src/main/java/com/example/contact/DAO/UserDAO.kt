package com.example.contact.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.contact.Model.User

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("SELECT * FROM User ORDER BY id ASC")
    fun readAllUser(): LiveData<List<User>>

    //@Query("DELETE from User WHERE ")
    //fun DeleteUser(user: User)
}