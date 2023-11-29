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
//
//    private val _nameList = MutableStateFlow<List<String>>(emptyList())
//    val nameList: StateFlow<List<String>> = _nameList.asStateFlow()
//
//    private val _courseList = MutableStateFlow<List<String>>(emptyList())
//    val courseList: StateFlow<List<String>> = _courseList.asStateFlow()

    private val _mentorDetails = MutableStateFlow<Map<String, Any>>(emptyMap())
    val mentorDetails: StateFlow<Map<String, Any>> = _mentorDetails.asStateFlow()

    fun setUsername(value: String) {
        _username.value = value
    }

    fun setMentorname(value: String) {
        _mentorname.value = value
    }

//    fun addToNameList(item: String) {
//        val currentList = _nameList.value.toMutableList()
//        currentList.add(item)
//        _nameList.value = currentList
//    }
//
//    fun addToCourseList(item: String) {
//        val currentList = _courseList.value.toMutableList()
//        currentList.add(item)
//        _courseList.value = currentList
//    }

    fun addMentorDetail(key: String, value: Any) {
        val currentDetails = _mentorDetails.value.toMutableMap()
        currentDetails[key] = value
        _mentorDetails.value = currentDetails
    }
}