package com.example.odev_3.data.repository

import android.util.Log
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
    override fun getEmployees(callback: (List<Employee>) -> Unit) {
        api.getEmployees().enqueue(object : Callback<Employees> {
            override fun onResponse(
                call: Call<Employees>,
                response: Response<Employees>
            ) {
                if (response.isSuccessful) {
                    val lst = response.body()?.data ?: listOf()
                    Log.e("denemeService", response.body().toString())
                    callback(lst)
                } else {
                    Log.e("hata", response.toString())
                }
            }

            override fun onFailure(call: Call<Employees>, t: Throwable) {
                Log.e("err", t.message.toString())
            }
        })
    }


}