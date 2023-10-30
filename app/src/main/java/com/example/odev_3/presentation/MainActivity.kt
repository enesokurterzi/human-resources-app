package com.example.odev_3.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.odev_3.ServiceRepository
import com.example.odev_3.models.Employee
import com.example.odev_3.presentation.ui.theme.Odev_3Theme
import com.example.odev_3.presentation.viewmodels.HumanResourcesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val vm: HumanResourcesViewModel = HumanResourcesViewModel(ServiceRepository())
        vm.getEmployees()

        setContent {
            Odev_3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {


                    EmployeesDisplay(vm.state)
                    Log.d("deneme", vm.state.toString())
                }
            }
        }
    }
}

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

@Composable
fun EmployeesDisplay(lst: List<Employee>) {
    LazyColumn(

    ) {
        this.items(lst) {
            EmployeeDisplay(e = it)
        }

    }
}