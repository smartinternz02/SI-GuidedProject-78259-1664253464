package com.example.groceryapp.ui.home

import android.widget.ScrollView
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.example.groceryapp.models.PopularModel
import com.example.groceryapp.adapters.PopularAdapters
import com.google.firebase.firestore.FirebaseFirestore
import com.example.groceryapp.models.HomeCategory
import com.example.groceryapp.adapters.HomeAdapter
import com.example.groceryapp.models.RecommendedModel
import com.example.groceryapp.adapters.RecommendedAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import com.example.groceryapp.R
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.QueryDocumentSnapshot
import android.widget.Toast
import android.annotation.SuppressLint
import android.view.View
import androidx.fragment.app.Fragment
import java.util.ArrayList

class HomeFragment : Fragment() {
    var scrollView: ScrollView? = null
    var progressBar: ProgressBar? = null
    var popularRec: RecyclerView? = null
    var homeCatRec: RecyclerView? = null
    var recommendedRec: RecyclerView? = null
    var popularModelList: MutableList<PopularModel>? = null
    var popularAdapters: PopularAdapters? = null
    var db: FirebaseFirestore? = null

    //Home category
    var categoryList: MutableList<HomeCategory>? = null
    var homeAdapter: HomeAdapter? = null

    //Recommended
    var recommendedModelList: MutableList<RecommendedModel>? = null
    var recommendedAdapter: RecommendedAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        db = FirebaseFirestore.getInstance()
        popularRec = root.findViewById(R.id.pop_rec)
        homeCatRec = root.findViewById(R.id.explore_rec)
        recommendedRec = root.findViewById(R.id.recommended_rec)
        scrollView = root.findViewById(R.id.scroll_view)
        progressBar = root.findViewById(R.id.progressbar)
        progressBar.setVisibility(View.VISIBLE)
        scrollView.setVisibility(View.GONE)

        //Popular items
        popularRec.setLayoutManager(LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false))
        popularModelList = ArrayList()
        popularAdapters = PopularAdapters(activity, popularModelList)
        popularRec.setAdapter(popularAdapters)
        db!!.collection("PopularProducts")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result) {
                        val popularModel = document.toObject(
                            PopularModel::class.java
                        )
                        popularModelList.add(popularModel)
                        popularAdapters!!.notifyDataSetChanged()
                        progressBar.setVisibility(View.GONE)
                        scrollView.setVisibility(View.VISIBLE)
                    }
                } else {
                    Toast.makeText(activity, "Error" + task.exception, Toast.LENGTH_SHORT).show()
                }
            }


        //Home Category
        homeCatRec.setLayoutManager(LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false))
        categoryList = ArrayList()
        homeAdapter = HomeAdapter(activity, categoryList)
        homeCatRec.setAdapter(homeAdapter)
        db!!.collection("HomeCategory")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result) {
                        val homeCategory = document.toObject(
                            HomeCategory::class.java
                        )
                        categoryList.add(homeCategory)
                        homeAdapter!!.notifyDataSetChanged()
                        progressBar.setVisibility(View.GONE)
                        scrollView.setVisibility(View.VISIBLE)
                    }
                } else {
                    Toast.makeText(activity, "Error" + task.exception, Toast.LENGTH_SHORT).show()
                }
            }


        //Recommended
        recommendedRec.setLayoutManager(
            LinearLayoutManager(
                activity,
                RecyclerView.HORIZONTAL,
                false
            )
        )
        recommendedModelList = ArrayList()
        recommendedAdapter = RecommendedAdapter(activity, recommendedModelList)
        recommendedRec.setAdapter(recommendedAdapter)
        db!!.collection("Recommended")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result) {
                        val recommendedModel = document.toObject(
                            RecommendedModel::class.java
                        )
                        recommendedModelList.add(recommendedModel)
                        recommendedAdapter!!.notifyDataSetChanged()
                        progressBar.setVisibility(View.GONE)
                        scrollView.setVisibility(View.VISIBLE)
                    }
                } else {
                    Toast.makeText(activity, "Error" + task.exception, Toast.LENGTH_SHORT).show()
                }
            }
        return root
    }
}