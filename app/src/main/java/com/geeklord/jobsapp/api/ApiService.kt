package com.geeklord.jobsapp.api

import com.geeklord.jobsapp.Models.JobResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET
    suspend fun getAllJobs(@Query("page") page: Int): Response<JobResponse>

}