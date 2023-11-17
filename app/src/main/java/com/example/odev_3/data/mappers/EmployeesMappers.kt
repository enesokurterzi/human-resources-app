package com.example.odev_3.data.mappers

import com.example.odev_3.data.remote.humanresources.EmployeeDto
import com.example.odev_3.domain.local.humanresources.Employee

fun EmployeeDto.toEmployee(): Employee {
    return Employee(
        id = id,
        employeeName = employeeName,
        employeeSalary = employeeSalary,
        employeeAge = employeeAge,
        profileImage = profileImage
    )
}