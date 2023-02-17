package com.example.assignment2.ui.rooms

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.view.ViewCompat.setBackgroundTintList
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment2.R
import com.example.assignment2.data.model.room.RoomModelItemModel
import com.example.assignment2.databinding.RoomItemBinding
import com.example.assignment2.util.DateTimeUtil.toDate

class RoomsAdapter(val roomList: ArrayList<RoomModelItemModel>) :
    RecyclerView.Adapter<RoomsAdapter.ViewHolder>() {

    inner class ViewHolder(val item: RoomItemBinding) : RecyclerView.ViewHolder(item.root) {
        fun setup(roomModelItemModel: RoomModelItemModel) {
            item.tvRoomName.text = roomModelItemModel.id
            item.tvDate.text = roomModelItemModel.createdAt?.toDate("dd/MM/yyyy")
            item.tvStatus.text =
                if (roomModelItemModel.isOccupied == true) "Occupied" else "Available"
            item.tvMaxValue.text = roomModelItemModel.maxOccupancy.toString()
            val color = if (roomModelItemModel.isOccupied == true) "#eda691" else "#5c9669"
            item.tvStatus.setBackgroundColor(Color.parseColor(color))
//            setBackgroundTintList(contextInstance.getResources().getColorStateList(R.color.your_xml_name));

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        RoomItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun getItemCount() = roomList.size

    override fun onBindViewHolder(holder: RoomsAdapter.ViewHolder, position: Int) {
        holder.setup(roomList[position])
    }

}
