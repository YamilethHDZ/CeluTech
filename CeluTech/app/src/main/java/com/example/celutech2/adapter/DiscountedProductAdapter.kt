package com.example.celutech2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.celutech2.R
import com.example.celutech2.model.DiscountedProducts

class DiscountedProductAdapter(private val context: Context, private val discountedProductsList: List<DiscountedProducts>) :
    RecyclerView.Adapter<DiscountedProductAdapter.DiscountedProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscountedProductViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.discounted_row_items, parent, false)
        return DiscountedProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: DiscountedProductViewHolder, position: Int) {
        holder.discountImageView.setImageResource(discountedProductsList[position].imageurl ?: R.drawable.b1)
    }

    override fun getItemCount(): Int {
        return discountedProductsList.size
    }

    class DiscountedProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val discountImageView: ImageView = itemView.findViewById(R.id.discountImage)
    }
}