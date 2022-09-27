package com.example.groceryapp.activities

import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import androidx.recyclerview.widget.RecyclerView
import com.example.groceryapp.adapters.ViewAllAdapter
import com.example.groceryapp.models.ViewAllModel
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.groceryapp.R
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.DocumentSnapshot
import java.util.ArrayList

class ViewAllActivity : AppCompatActivity() {
    var firestore: FirebaseFirestore? = null
    var recyclerView: RecyclerView? = null
    var viewAllAdapter: ViewAllAdapter? = null
    var viewAllModelList: MutableList<ViewAllModel?>? = null
    var toolbar: Toolbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_all)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        firestore = FirebaseFirestore.getInstance()
        val type = intent.getStringExtra("type")
        recyclerView = findViewById(R.id.view_all_rec)
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        viewAllModelList = ArrayList()
        viewAllAdapter = ViewAllAdapter(this, viewAllModelList)


        //////////getting fruits
        if (type != null && type.equals("fruit", ignoreCase = true)) {
            firestore!!.collection("AllProducts").whereEqualTo("type", "fruit").get()
                .addOnCompleteListener { task ->
                    for (documentSnapshot in task.result.documents) {
                        val viewAllModel = documentSnapshot.toObject(
                            ViewAllModel::class.java
                        )
                        viewAllModelList.add(viewAllModel)
                        viewAllAdapter!!.notifyDataSetChanged()
                    }
                }
        }

        //////////getting vegetable
        if (type != null && type.equals("vegetable", ignoreCase = true)) {
            firestore!!.collection("AllProducts").whereEqualTo("type", "vegetable").get()
                .addOnCompleteListener { task ->
                    for (documentSnapshot in task.result.documents) {
                        val viewAllModel = documentSnapshot.toObject(
                            ViewAllModel::class.java
                        )
                        viewAllModelList.add(viewAllModel)
                        viewAllAdapter!!.notifyDataSetChanged()
                    }
                }
        }
        //////////getting eggs
        if (type != null && type.equals("eggs", ignoreCase = true)) {
            firestore!!.collection("AllProducts").whereEqualTo("type", "eggs").get()
                .addOnCompleteListener { task ->
                    for (documentSnapshot in task.result.documents) {
                        val viewAllModel = documentSnapshot.toObject(
                            ViewAllModel::class.java
                        )
                        viewAllModelList.add(viewAllModel)
                        viewAllAdapter!!.notifyDataSetChanged()
                    }
                }
        }
    }
}