package com.geeklord.jobsapp.View

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.geeklord.jobsapp.Paging.JobsPagingAdapter
import com.geeklord.jobsapp.Utils.Constants.TAG
import com.geeklord.jobsapp.ViewModels.JobsViewModel
import com.geeklord.jobsapp.databinding.FragmentJobsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JobsFragment : Fragment() {

    private var _binding : FragmentJobsBinding? = null
    private val binding get() = _binding!!

    private val jobsViewModel by viewModels<JobsViewModel>()

    private lateinit var adapter : JobsPagingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentJobsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        adapter = JobsPagingAdapter()
        binding.jobsRecyclerView.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        binding.jobsRecyclerView.adapter = adapter
        binding.jobsRecyclerView.setHasFixedSize(true)

        jobsViewModel.list.observe(viewLifecycleOwner) {
            adapter.submitData(lifecycle, it)
            Log.d(TAG, "onViewCreated: $it")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
