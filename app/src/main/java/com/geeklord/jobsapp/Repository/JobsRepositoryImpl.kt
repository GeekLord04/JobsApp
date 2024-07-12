package com.geeklord.jobsapp.Repository


import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.geeklord.jobsapp.Paging.JobsPagingSource
import com.geeklord.jobsapp.api.ApiService
import javax.inject.Inject

class JobsRepositoryImpl @Inject constructor(private val apiService: ApiService) {
    fun getAllJobs() = Pager(
        config = PagingConfig(pageSize = 15, maxSize = 50),
        pagingSourceFactory = { JobsPagingSource(apiService) }
    ).liveData



}