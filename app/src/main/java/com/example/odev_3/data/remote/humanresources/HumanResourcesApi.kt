package com.example.odev_3.data.remote.humanresources

import com.example.odev_3.domain.models.Employees
import retrofit2.Call
import retrofit2.http.GET

interface HumanResourcesApi {

    @GET("/api/v1/employees")
    fun getEmployees() : Call<Employees>

}