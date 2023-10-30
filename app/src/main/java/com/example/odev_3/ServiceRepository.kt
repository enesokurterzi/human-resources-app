package com.example.odev_3

import android.util.Log
import com.example.odev_3.models.Employee
import com.example.odev_3.models.Employees
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceRepository {

    var retrofit = Retrofit
        .Builder()
        .baseUrl("https://dummy.restapiexample.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var proxy: HumanResourcesApi = retrofit.create(HumanResourcesApi::class.java)

    fun getEmployees(callback: (List<Employee>) -> Unit) {
        proxy.getEmployees().enqueue(object : Callback<Employees> {
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