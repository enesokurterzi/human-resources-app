package com.example.odev_3.data.repository

import android.util.Log
import com.example.odev_3.data.mappers.toEmployee
import com.example.odev_3.data.remote.humanresources.EmployeesDto
import com.example.odev_3.data.remote.humanresources.HumanResourcesApi
import com.example.odev_3.domain.local.humanresources.Employee
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
        api.getEmployees().enqueue(object : Callback<EmployeesDto> {
            override fun onResponse(
                call: Call<EmployeesDto>,
                response: Response<EmployeesDto>
            ) {
                if (response.isSuccessful) {
                    val lst = response.body()?.data ?: listOf()
                    callback(lst.map { it.toEmployee() })
                } else {
                    errorCode(response.code())
                }
            }

            override fun onFailure(call: Call<EmployeesDto>, t: Throwable) {
                Log.e("err", t.message.toString())
            }
        })
    }


}