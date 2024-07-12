package com.geeklord.jobsapp.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geeklord.jobsapp.Repository.JobsRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.paging.cachedIn
import javax.inject.Inject

@HiltViewModel
class JobsViewModel @Inject constructor(private val repository: JobsRepositoryImpl) : ViewModel() {

    val list = repository.getAllJobs().cachedIn(viewModelScope)


}