package com.example.odev_3.presentation.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.odev_3.domain.models.Employee

@Composable
fun EmployeesDisplay(lst: List<Employee>) {
    LazyColumn(

    ) {
        this.items(lst) {
            EmployeeDisplay(e = it)
        }

    }
}