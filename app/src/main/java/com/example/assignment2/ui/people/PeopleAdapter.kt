package com.example.assignment2.ui.people

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignment2.R
import com.example.assignment2.data.model.people.PeopleModelItemModel
import com.example.assignment2.databinding.PeopleItemBinding

private const val TAG = "PeopleAdapter"
class PeopleAdapter(
    val peopleList: ArrayList<PeopleModelItemModel>,
    val clickListener: (PeopleModelItemModel) -> Unit
) : RecyclerView.Adapter<PeopleAdapter.ViewHolder>() {


    inner class ViewHolder(private val view: PeopleItemBinding) :
        RecyclerView.ViewHolder(view.root) {

        fun setup(peopleModelItemModel: PeopleModelItemModel) {
            with(itemView) {
                Log.d(TAG, "setup:avatar =  ${peopleModelItemModel.avatar}")
                Glide.with(context)
                    .load(peopleModelItemModel.avatar)
                    .placeholder(R.drawable.animate_loading)
                    .centerCrop()
                    .into(view.ivUserPic)
            }
            view.tvTitle.text = "${peopleModelItemModel.firstName} ${peopleModelItemModel.lastName}"
            view.tvDesc.text = peopleModelItemModel.jobtitle
            view.ivUserPic.setOnClickListener {
                clickListener.invoke(peopleModelItemModel)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        PeopleItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun getItemCount(): Int = peopleList.size

    override fun onBindViewHolder(holder: PeopleAdapter.ViewHolder, position: Int) {
        holder.setup(peopleList[position])
    }
}