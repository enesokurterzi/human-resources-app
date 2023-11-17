package com.example.odev_3.presentation.viewmodels

import com.example.odev_3.domain.local.humanresources.Employee

data class EmployeeState(
    val isLoading: Boolean = false,
    val errorCode: Int = 0,
    val employeeList: List<Employee> = listOf()
)
