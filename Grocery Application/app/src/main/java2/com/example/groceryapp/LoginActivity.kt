package com.example.groceryapp

import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import android.os.Bundle
import com.example.groceryapp.R
import android.content.Intent
import com.example.groceryapp.RegistrationActivity
import android.text.TextUtils
import android.view.View
import android.widget.*
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.example.groceryapp.MainActivity

class LoginActivity : AppCompatActivity() {
    var signIn: Button? = null
    var email: EditText? = null
    var password: EditText? = null
    var signUp: TextView? = null
    var auth: FirebaseAuth? = null
    var progressBar: ProgressBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
        progressBar = findViewById(R.id.progressbar)
        signIn = findViewById(R.id.login_btn)
        email = findViewById(R.id.email_login)
        password = findViewById(R.id.password_login)
        signUp = findViewById(R.id.sign_up)
        signUp.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this@LoginActivity,
                    RegistrationActivity::class.java
                )
            )
        })
        signIn.setOnClickListener(View.OnClickListener {
            loginUser()
        })
    }

    private fun loginUser() {
        val userEmail = email!!.text.toString()
        val userPassword = password!!.text.toString()
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
        //Login User
        auth!!.signInWithEmailAndPassword(userEmail, userPassword)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    progressBar!!.visibility = View.GONE
                    Toast.makeText(this@LoginActivity, "Login Successfully", Toast.LENGTH_SHORT)
                        .show()
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                } else {
                    progressBar!!.visibility = View.GONE
                    Toast.makeText(
                        this@LoginActivity,
                        "Error" + task.isSuccessful,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}