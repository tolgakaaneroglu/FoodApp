package com.demo.foodorderanddeliveryappkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.demo.foodorderanddeliveryappkotlin.R
import com.demo.foodorderanddeliveryappkotlin.models.Hours
import com.demo.foodorderanddeliveryappkotlin.models.RestaurentModel
import java.text.SimpleDateFormat
import java.util.*

class RestaurantListAdapter(val restaurantList: List<RestaurentModel?>?, val clickListener: RestaurantListClickListener): RecyclerView.Adapter<RestaurantListAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RestaurantListAdapter.MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_restautant_list_row, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestaurantListAdapter.MyViewHolder, position: Int) {
        holder.bind(restaurantList?.get(position))
        holder.itemView.setOnClickListener {
            clickListener.onItemClick(restaurantList?.get(position)!!)
        }
    }

    override fun getItemCount(): Int {
        return restaurantList?.size!!
    }

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view)
    {
        val thumbImage: ImageView = view.findViewById(R.id.thumbImage)
        val tvRestaurantName: TextView = view.findViewById(R.id.tvRestaurantName)


        fun bind(restaurentModel: RestaurentModel?) {
            tvRestaurantName.text = restaurentModel?.name

            Glide.with(thumbImage)
                .load(restaurentModel?.image)
                .into(thumbImage)
        }
    }



    interface RestaurantListClickListener {
        fun onItemClick(restaurantModel: RestaurentModel)
    }

}