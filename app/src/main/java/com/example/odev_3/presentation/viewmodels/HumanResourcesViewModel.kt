package com.example.odev_3.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.odev_3.domain.models.Employee
import com.example.odev_3.domain.repository.ServiceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HumanResourcesViewModel @Inject constructor(
    private val repository: ServiceRepository
) : ViewModel() {

    var errorState by mutableStateOf(0)
        private set

    var state by mutableStateOf(listOf<Employee>())
        private set

    fun getEmployees() {
        repository.getEmployees(
            errorCode = {
                errorState = it
            },
            callback = {
                state = it
            }
        )

    }

}