package com.example.odev_3.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.odev_3.R
import com.example.odev_3.domain.models.Employee
import com.example.odev_3.presentation.ui.theme.CardBackground

@Composable
fun EmployeeDisplay(e: Employee) {
    ElevatedCard(
        colors = CardDefaults.elevatedCardColors(
            containerColor = CardBackground,
        )


    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = e.employeeName, style = MaterialTheme.typography.titleLarge)
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = buildAnnotatedString {
                        val boldStyle = SpanStyle(
                            color = MaterialTheme.typography.bodyMedium.color,
                            fontWeight = FontWeight.SemiBold
                        )
                        pushStyle(boldStyle)
                        append("Maaş: ")
                        pop()
                        append("${e.employeeSalary} TL")
                    }
                )
                Text(
                    text = buildAnnotatedString {
                        val boldStyle = SpanStyle(
                            color = MaterialTheme.typography.bodyMedium.color,
                            fontWeight = FontWeight.SemiBold
                        )
                        pushStyle(boldStyle)
                        append("Yaş: ")
                        pop()
                        append("${e.employeeAge}")
                    }
                )
            }
        }

    }

}