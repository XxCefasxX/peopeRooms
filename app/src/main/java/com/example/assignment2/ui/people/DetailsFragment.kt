package com.example.assignment2.ui.people

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.assignment2.data.model.people.PeopleModelItemModel
import com.example.assignment2.databinding.FragmentPeopleBinding
import com.example.assignment2.databinding.PeopleDetailsFragmeentBinding
import com.example.assignment2.util.DateTimeUtil.toDate
import com.example.assignment2.util.ResponseType
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "DetailsFragment"

@AndroidEntryPoint
class DetailsFragment() : Fragment() {

    private var _binding: PeopleDetailsFragmeentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PeopleViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PeopleDetailsFragmeentBinding.inflate(inflater, container, false)
        viewModel.person.observe(viewLifecycleOwner) {
            Log.d(TAG, "onCreateView: is working ${it}")
            initViews(it)
        }
        viewModel.getDetails()
        Log.d(TAG, "onCreateView: ${viewModel.person.value}")

        return binding.root
    }

    private fun initViews(peopleModelItemModel: PeopleModelItemModel) {
        Log.d(TAG, "initViews: $peopleModelItemModel")
        binding.apply {
            Log.d(TAG, "initViews: ${peopleModelItemModel}")
            tvCreatedDate.text =
                "Registered at: ${peopleModelItemModel.createdAt?.toDate("dd/MM/yyyy")}"
            tvEmail.text = "Email: ${peopleModelItemModel.email}"
            tvFromName.text =
                if (peopleModelItemModel.fromName != "") "From: ${peopleModelItemModel.fromName}" else ""
            tvSize.text =if (peopleModelItemModel.fromName != "") "From: ${peopleModelItemModel.size}" else ""
            tvFavColor.text = if (peopleModelItemModel.fromName != "") "From: ${peopleModelItemModel.favouriteColor}" else ""
            tvTo.text = if (peopleModelItemModel.fromName != "") "From: ${peopleModelItemModel.to}" else ""
            tvType.text = if (peopleModelItemModel.fromName != "") "From: ${peopleModelItemModel.type}" else ""
        }
    }
}