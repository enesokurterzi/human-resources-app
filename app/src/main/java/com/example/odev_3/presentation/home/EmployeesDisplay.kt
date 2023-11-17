package com.example.odev_3.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.odev_3.domain.local.humanresources.Employee

@Composable
fun EmployeesDisplay(lst: List<Employee>) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)

    ) {
        this.items(lst) {
            EmployeeDisplay(e = it)
        }

    }
}