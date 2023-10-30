package com.example.odev_3.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.odev_3.ServiceRepository
import com.example.odev_3.models.Employee

class HumanResourcesViewModel(sr: ServiceRepository) : ViewModel() {
    private var repository: ServiceRepository

    var state by mutableStateOf(listOf<Employee>())

    init {
        this.repository = sr
    }

//    val department: List<Employee> = repository.getEmployees()

    fun getEmployees() {
        repository.getEmployees {
            state = it
            Log.e("state", state.toString())
        }

    }

}