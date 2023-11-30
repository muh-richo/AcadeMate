package com.example.academate.ui.presentation.login_screen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class UserViewModel : ViewModel() {
    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username.asStateFlow()

    private val _mentorname = MutableStateFlow("")
    val mentorname: StateFlow<String> = _mentorname.asStateFlow()

    private val _mentorDetails = MutableStateFlow<Map<String, Any>>(emptyMap())
    val mentorDetails: StateFlow<Map<String, Any>> = _mentorDetails.asStateFlow()

    fun setUsername(value: String) {
        _username.value = value
    }

    fun setMentorname(value: String) {
        _mentorname.value = value
    }

    fun addMentorDetail(key: String, value: Any) {
        val currentDetails = _mentorDetails.value.toMutableMap()
        currentDetails[key] = value
        _mentorDetails.value = currentDetails
    }
}