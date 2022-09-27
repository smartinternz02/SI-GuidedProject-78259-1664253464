package com.example.groceryapp.ui.category

import com.google.firebase.firestore.FirebaseFirestore
import androidx.recyclerview.widget.RecyclerView
import com.example.groceryapp.models.NavCategoryModel
import com.example.groceryapp.adapters.NavCategoryAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import com.example.groceryapp.R
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.util.ArrayList

class CategoryFragment : Fragment() {
    var db: FirebaseFirestore? = null
    var recyclerView: RecyclerView? = null
    var categoryModelList: MutableList<NavCategoryModel>? = null
    var navCategoryAdapter: NavCategoryAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_category, container, false)
        db = FirebaseFirestore.getInstance()
        this = root.findViewById(R.id.cat_rec)
        //Popular items
        with(recyclerView) {
            db = FirebaseFirestore.getInstance()
            this = root.findViewById(R.id.cat_rec)
            //Popular items
            setLayoutManager(LinearLayoutManager(activity, RecyclerView.VERTICAL, false))
        }
        categoryModelList = ArrayList()
        navCategoryAdapter = NavCategoryAdapter(activity,
            categoryModelList as ArrayList<NavCategoryModel>
        )
        recyclerView.setAdapter(navCategoryAdapter)
        db!!.collection("NavCategory")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result) {
                        val navCategoryModel = document.toObject(
                            NavCategoryModel::class.java
                        )
                        (categoryModelList as ArrayList<NavCategoryModel>).add(navCategoryModel)
                        navCategoryAdapter!!.notifyDataSetChanged()
                    }
                } else {
                    Toast.makeText(activity, "Error" + task.exception, Toast.LENGTH_SHORT).show()
                }
            }
        return root
    }
}