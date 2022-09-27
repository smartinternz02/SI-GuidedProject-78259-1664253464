package com.example.groceryapp.ui.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.groceryapp.R
import com.example.groceryapp.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private val binding: FragmentProfileBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }
}