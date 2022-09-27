package com.example.groceryapp.adapters

import android.content.Context
import com.example.groceryapp.models.HomeCategory
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import com.example.groceryapp.R
import com.bumptech.glide.Glide
import android.content.Intent
import android.view.View
import android.widget.ImageView
import com.example.groceryapp.activities.ViewAllActivity
import android.widget.TextView

class HomeAdapter(var context: Context, var categoryList: List<HomeCategory>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.home_cat_items, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(categoryList[position].img_url).into(holder.catImg)
        holder.name.text = categoryList[position].name
        holder.itemView.setOnClickListener {
            val intent = Intent(context, ViewAllActivity::class.java)
            intent.putExtra("type", categoryList[position].type)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var catImg: ImageView
        var name: TextView

        init {
            catImg = itemView.findViewById(R.id.home_cat_img)
            name = itemView.findViewById(R.id.cat_home_name)
        }
    }
}