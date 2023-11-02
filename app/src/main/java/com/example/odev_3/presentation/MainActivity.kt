package com.example.odev_3.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.example.odev_3.R
import com.example.odev_3.presentation.home.EmployeesDisplay
import com.example.odev_3.presentation.ui.theme.Background
import com.example.odev_3.presentation.ui.theme.Odev_3Theme
import com.example.odev_3.presentation.viewmodels.HumanResourcesViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val vm: HumanResourcesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Odev_3Theme {

                val isLoading = vm.employeeState.isLoading
                val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = isLoading)

                SwipeRefresh(
                    state = swipeRefreshState,
                    onRefresh = vm::loadStuff,
                ) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = Background
                    ) {
                        if (vm.employeeState.errorCode == 429) {
                            Toast.makeText(
                                this,
                                "Uyarı: Çok fazla deneme yapıldı!",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                        EmployeesDisplay(vm.employeeState.employeeList)
                    }
                }
            }
        }
    }
}

