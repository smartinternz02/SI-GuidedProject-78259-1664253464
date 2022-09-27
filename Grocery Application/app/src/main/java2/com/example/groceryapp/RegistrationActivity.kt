package com.example.groceryapp

import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import android.os.Bundle
import com.example.groceryapp.R
import android.content.Intent
import com.example.groceryapp.LoginActivity
import android.text.TextUtils
import android.view.View
import android.widget.*
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.example.groceryapp.UserModel
import com.example.groceryapp.MainActivity

class RegistrationActivity : AppCompatActivity() {
    var signUp: Button? = null
    var name: EditText? = null
    var email: EditText? = null
    var password: EditText? = null
    var signIn: TextView? = null
    var auth: FirebaseAuth? = null
    var database: FirebaseDatabase? = null
    var progressBar: ProgressBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        progressBar = findViewById(R.id.progressbar)
        progressBar.setVisibility(View.GONE)
        signUp = findViewById(R.id.reg_btn)
        name = findViewById(R.id.name)
        email = findViewById(R.id.email_reg)
        password = findViewById(R.id.password_reg)
        signIn = findViewById(R.id.sign_in)
        signIn.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@RegistrationActivity,
                    LoginActivity::class.java
                )
            )
        })
        signUp.setOnClickListener(View.OnClickListener {
            createUser()
            progressBar.setVisibility(View.VISIBLE)
        })
    }

    private fun createUser() {
        val userName = name!!.text.toString()
        val userEmail = email!!.text.toString()
        val userPassword = password!!.text.toString()
        if (TextUtils.isEmpty(userName)) {
            Toast.makeText(this, "Name is Empty!", Toast.LENGTH_SHORT).show()
            return
        }
        if (TextUtils.isEmpty(userEmail)) {
            Toast.makeText(this, "Email is Empty!", Toast.LENGTH_SHORT).show()
            return
        }
        if (TextUtils.isEmpty(userPassword)) {
            Toast.makeText(this, "Password is Empty!", Toast.LENGTH_SHORT).show()
            return
        }
        if (userPassword.length < 6) {
            Toast.makeText(
                this,
                "Password Length must be greater then 6 letter",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        //Create User
        auth!!.createUserWithEmailAndPassword(userEmail, userPassword)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val userModel = UserModel(userName, userEmail, userPassword)
                    val id = task.result.user!!.uid
                    database!!.reference.child("Users").child(id).setValue(userModel)
                    progressBar!!.visibility = View.GONE
                    Toast.makeText(
                        this@RegistrationActivity,
                        "Registration Successful",
                        Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(this@RegistrationActivity, MainActivity::class.java))
                } else {
                    progressBar!!.visibility = View.GONE
                    Toast.makeText(
                        this@RegistrationActivity,
                        "Error:" + task.exception,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}