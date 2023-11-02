package com.example.odev_3.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.odev_3.domain.models.Employee
import com.example.odev_3.domain.repository.ServiceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HumanResourcesViewModel @Inject constructor(
    private val repository: ServiceRepository
) : ViewModel() {

    var employeeState by mutableStateOf(EmployeeState())
        private set

    init {
        getEmployees()
    }

    fun getEmployees() {
        repository.getEmployees(
            errorCode = {
                employeeState = employeeState.copy(errorCode = it)
            },
            callback = {
                employeeState = employeeState.copy(employeeList = it)
            }
        )
    }

    fun loadStuff() {
        employeeState = employeeState.copy(errorCode = 0)
        getEmployees()
        viewModelScope.launch {
            employeeState = employeeState.copy(isLoading = true)
            delay(2000L)
            employeeState = employeeState.copy(isLoading = false)
        }
    }

}