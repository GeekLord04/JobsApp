package com.geeklord.jobsapp.Paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.geeklord.jobsapp.Models.JobDetails
import com.geeklord.jobsapp.databinding.JobItemBinding

class JobsPagingAdapter : PagingDataAdapter<JobDetails, JobsPagingAdapter.JobsViewHolder> (ComparatorDiffUtil()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobsViewHolder {
        val binding = JobItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JobsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JobsViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.bind(it)
        }
    }

    class JobsViewHolder(private val binding: JobItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(result: JobDetails) {
            binding.jobTitle.text = result.title
            binding.jobCompany.text = result.companyName
        }

    }

    class ComparatorDiffUtil : DiffUtil.ItemCallback<JobDetails>() {
        override fun areItemsTheSame(oldItem: JobDetails, newItem: JobDetails): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: JobDetails, newItem: JobDetails): Boolean {
            return oldItem == newItem
        }
    }


}