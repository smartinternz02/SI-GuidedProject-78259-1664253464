package com.example.groceryapp.adapters


import com.example.groceryapp.models.PopularModel
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import com.example.groceryapp.R
import android.annotation.SuppressLint
import android.content.Context
import com.bumptech.glide.Glide
import android.content.Intent
import android.view.View
import android.widget.ImageView
import com.example.groceryapp.activities.ViewAllActivity
import android.widget.TextView

class PopularAdapters(var context: Context, var popularModelList: List<PopularModel>) :
    RecyclerView.Adapter<PopularAdapters.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.popular_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        Glide.with(context).load(popularModelList[position].img_url).into(holder.popImg)
        holder.name.text = popularModelList[position].name
        holder.description.text = popularModelList[position].description
        holder.rating.text = popularModelList[position].rating
        holder.discount.text = popularModelList[position].discount
        holder.itemView.setOnClickListener {
            val intent = Intent(context, ViewAllActivity::class.java)
            intent.putExtra("type", popularModelList[position].type)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return popularModelList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var popImg: ImageView
        var name: TextView
        var description: TextView
        var rating: TextView
        var discount: TextView

        init {
            popImg = itemView.findViewById(R.id.pop_img)
            name = itemView.findViewById(R.id.pop_name)
            description = itemView.findViewById(R.id.pop_des)
            rating = itemView.findViewById(R.id.pop_rating)
            discount = itemView.findViewById(R.id.pop_discount)
        }
    }
}