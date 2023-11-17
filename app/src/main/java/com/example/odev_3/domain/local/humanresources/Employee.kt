package com.example.odev_3.domain.local.humanresources

import com.google.gson.annotations.SerializedName

data class Employee(
    val id: Long,
    val employeeName: String,
    val employeeSalary: Long,
    val employeeAge: Long,
    val profileImage: String
)
