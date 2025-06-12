package com.example.learnjetpackcompose.ui.screens.learnStateManagement

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LearnStateManagementModel: ViewModel() {
    // Private Variables
    private val _name = MutableLiveData<String>()
    private  val _surname = MutableLiveData<String>()

    // Exposed variables
    val name: LiveData<String> = _name
    val surname: LiveData<String> = _surname

    // Events
    fun onUserNameUpdate(newName: String) {
        _name.value = newName
    }

    fun onSurNameUpdate(newName: String) {
        _surname.value = newName
    }
}