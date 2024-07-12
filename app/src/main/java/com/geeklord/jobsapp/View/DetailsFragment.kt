package com.geeklord.jobsapp.View

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import com.geeklord.jobsapp.Models.JobDetails
import com.geeklord.jobsapp.Models.PrimaryDetails
import com.geeklord.jobsapp.databinding.FragmentDetailsBinding
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private var _binding : FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private var itemData : JobDetails? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()

    }

    private fun setData() {
        val json = arguments?.getString("jobData")
        if(json != null){
            itemData = Gson().fromJson(json, JobDetails::class.java)

            itemData?.let {item ->
                binding.tvPlace.text = "Place : ${item.primaryDetails.place}"
                binding.tvSalary.text = "Salary : ${item.primaryDetails.salary}"
                binding.tvJobType.text = "Job Type : ${item.primaryDetails.jobType}"
                binding.tvExperience.text = "Experience : ${item.primaryDetails.experience}"
                binding.tvQualification.text = "Qualification : ${item.primaryDetails.qualification}"
                binding.tvCompanyName.text = "Company : ${item.companyName}"
                binding.tvJobRole.text = "Job Role : ${item.jobRole}"

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}