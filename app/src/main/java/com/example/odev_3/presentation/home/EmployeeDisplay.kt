package com.example.odev_3.presentation.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.odev_3.domain.models.Employee

@Composable
fun EmployeeDisplay(e: Employee) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = e.employeeName)
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = "${e.employeeSalary} TL")
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = "${e.employeeAge}")
    }

}