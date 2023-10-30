package com.example.odev_3.models

import com.google.gson.annotations.SerializedName

data class Employees (
    val status: String,
    val data: List<Employee>,
    val message: String
)

data class Employee (
    val id: Long,

    @SerializedName("employee_name")
    val employeeName: String,

    @SerializedName("employee_salary")
    val employeeSalary: Long,

    @SerializedName("employee_age")
    val employeeAge: Long,

    @SerializedName("profile_image")
    val profileImage: String
)



