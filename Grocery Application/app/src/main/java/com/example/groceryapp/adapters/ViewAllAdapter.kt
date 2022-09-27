package com.example.groceryapp.adapters

import android.content.Context
import com.example.groceryapp.activities.ViewAllActivity
import com.example.groceryapp.models.ViewAllModel
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.example.groceryapp.R
import com.bumptech.glide.Glide
import android.widget.TextView

class ViewAllAdapter(viewAllActivity: ViewAllActivity?, viewAllAdapter: List<ViewAllModel?>?) :
    RecyclerView.Adapter<ViewAllAdapter.ViewHolder>() {
    var context: Context? = null
    var list: List<ViewAllModel>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_all_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context!!).load(list!![position].img_url).into(holder.imageView)
        holder.name.text = list!![position].name
        holder.price.setText(list!![position].price)
        holder.rating.text = list!![position].rating
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView
        var name: TextView
        var price: TextView
        var rating: TextView

        init {
            imageView = itemView.findViewById(R.id.view_img)
            name = itemView.findViewById(R.id.view_name)
            price = itemView.findViewById(R.id.view_price)
            rating = itemView.findViewById(R.id.view_rating)
        }
    }
}