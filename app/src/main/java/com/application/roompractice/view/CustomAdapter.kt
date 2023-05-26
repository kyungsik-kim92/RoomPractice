package com.application.roompractice.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.application.roompractice.R
import com.application.roompractice.db.Entity.NumberEntity

class CustomAdapter(private val dataSet: ArrayList<NumberEntity>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idArea: TextView
        val randomNum: TextView

        init {
            idArea = view.findViewById(R.id.id)
            randomNum = view.findViewById(R.id.randomNum)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.number_item, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.idArea.text = dataSet[position].id.toString()
        holder.randomNum.text = dataSet[position].randomNumber

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }


}