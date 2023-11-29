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

    private val _nameList = MutableStateFlow<Set<String>>(emptySet())
    val nameList: StateFlow<Set<String>> = _nameList.asStateFlow()

    private val _courseList = MutableStateFlow<Set<String>>(emptySet())
    val courseList: StateFlow<Set<String>> = _courseList.asStateFlow()

    fun setUsername(value: String) {
        _username.value = value
    }

    fun setMentorname(value: String) {
        _mentorname.value = value
    }

    fun addToNameList(item: String) {
        val currentList = _nameList.value.toMutableSet()
        currentList.add(item)
        _nameList.value = currentList
    }

    fun addToCourseList(item: String) {
        val currentList = _courseList.value.toMutableSet()
        currentList.add(item)
        _courseList.value = currentList
    }
}