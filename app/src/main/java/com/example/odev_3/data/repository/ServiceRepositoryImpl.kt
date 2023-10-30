package com.example.odev_3.data.repository

import android.util.Log
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import com.example.odev_3.data.remote.humanresources.HumanResourcesApi
import com.example.odev_3.domain.models.Employee
import com.example.odev_3.domain.models.Employees
import com.example.odev_3.domain.repository.ServiceRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ServiceRepositoryImpl @Inject constructor(
    private val api: HumanResourcesApi
) : ServiceRepository {
    override fun getEmployees(
        callback: (List<Employee>) -> Unit,
        errorCode: (Int) -> Unit
    ) {
        api.getEmployees().enqueue(object : Callback<Employees> {
            override fun onResponse(
                call: Call<Employees>,
                response: Response<Employees>
            ) {
                if (response.isSuccessful) {
                    val lst = response.body()?.data ?: listOf()
                    callback(lst)
                } else {
                    errorCode(response.code())
                }
            }

            override fun onFailure(call: Call<Employees>, t: Throwable) {
                Log.e("err", t.message.toString())
            }
        })
    }


}