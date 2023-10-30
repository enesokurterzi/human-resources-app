package com.example.odev_3.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.odev_3.presentation.home.EmployeesDisplay
import com.example.odev_3.presentation.ui.theme.Odev_3Theme
import com.example.odev_3.presentation.viewmodels.HumanResourcesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val vm: HumanResourcesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

