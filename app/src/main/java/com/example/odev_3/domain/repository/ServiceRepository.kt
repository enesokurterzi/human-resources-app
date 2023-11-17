package com.example.odev_3.domain.repository

import com.example.odev_3.domain.local.humanresources.Employee

interface ServiceRepository {
    fun getEmployees(callback: (List<Employee>) -> Unit, errorCode: (Int) -> Unit)
}