package com.example.groceryapp.adapters

import android.content.Context
import com.example.groceryapp.models.RecommendedModel
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.example.groceryapp.R
import com.bumptech.glide.Glide
import android.widget.TextView

class RecommendedAdapter(var context: Context, var list: List<RecommendedModel>) :
    RecyclerView.Adapter<RecommendedAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recommended_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(list[position].img_url).into(holder.imageView)
        holder.name.text = list[position].name
        holder.description.text = list[position].description
        holder.rating.text = list[position].rating
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView
        var name: TextView
        var description: TextView
        var rating: TextView

        init {
            imageView = itemView.findViewById(R.id.rec_img)
            name = itemView.findViewById(R.id.rec_name)
            description = itemView.findViewById(R.id.rec_dec)
            rating = itemView.findViewById(R.id.rec_rating)
        }
    }
}