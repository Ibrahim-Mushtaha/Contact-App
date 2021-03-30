package com.ix.ibrahim7.contact_app_assignment.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.ix.ibrahim7.contact_app_assignment.model.User
import com.ix.ibrahim7.contact_app_assignment.repository.MainRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListUserViewModel (private val repository: MainRepository = MainRepository.invoke()) : ViewModel() {

    private val dispatcher: CoroutineDispatcher = Dispatchers.IO

    fun getAllUsers() = GlobalScope.launch(dispatcher) { repository.getAllUsers() }
    fun addUser(user: User) = GlobalScope.launch(dispatcher) { repository.addUser(user) }

    fun getUserLiveData() = repository.UserLiveData
    fun AddUserLiveData() = repository.AddUserLiveData


    init {
        getAllUsers()
    }
}