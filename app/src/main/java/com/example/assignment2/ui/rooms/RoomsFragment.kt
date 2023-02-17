package com.example.assignment2.ui.rooms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment2.data.model.room.RoomModel
import com.example.assignment2.databinding.FragmentRoomsBinding
import com.example.assignment2.util.ResponseType
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RoomsFragment : Fragment() {

    private var _binding: FragmentRoomsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RoomsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRoomsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        viewModel.result.observe(viewLifecycleOwner) {
            when(it) {
                is ResponseType.Loading -> {
                    Toast.makeText(context, "Loading. . .!", Toast.LENGTH_SHORT).show()
                }
                is ResponseType.Success-> {
                   initView(it.data)
                }
                is ResponseType.Error -> {
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

        viewModel.getRoomsList()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun initView(data: RoomModel?) {
        val gridLayout=GridLayoutManager(context,2, GridLayoutManager.VERTICAL,false)



        data?.let {
            binding.rvRooms.apply {
                binding.rvRooms.layoutManager=gridLayout
                adapter = RoomsAdapter(it)
            }
        }
    }
}