package com.example.groceryapp.adapters

import android.content.Context
import com.example.groceryapp.models.NavCategoryModel
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.example.groceryapp.R
import com.bumptech.glide.Glide
import android.widget.TextView
import androidx.fragment.app.FragmentActivity

class NavCategoryAdapter(var context: FragmentActivity?, var list: List<NavCategoryModel>) :
    RecyclerView.Adapter<NavCategoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.nav_cat_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(list[position].img_url).into(holder.imageView)
        holder.name.text = list[position].name
        holder.discount.text = list[position].discount
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView
        var name: TextView
        var discount: TextView

        init {
            imageView = itemView.findViewById(R.id.cat_nav_img)
            name = itemView.findViewById(R.id.nav_cat_name)
            discount = itemView.findViewById(R.id.nav_cat_discount)
        }
    }
}