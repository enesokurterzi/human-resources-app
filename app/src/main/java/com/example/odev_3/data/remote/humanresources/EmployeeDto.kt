package com.example.odev_3.data.remote.humanresources

import com.google.gson.annotations.SerializedName

data class EmployeeDto (
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
