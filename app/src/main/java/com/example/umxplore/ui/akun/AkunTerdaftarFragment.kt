package com.example.umxplore.ui.akun

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import com.example.umxplore.R
import com.example.umxplore.helper.SharedPref


class AkunTerdaftarFragment : Fragment() {
    private lateinit var s: SharedPref
    private lateinit var btnLogout: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_akun_terdaftar, container, false)

        s = SharedPref(requireActivity())
        btnLogout = view.findViewById(R.id.btn_Logout)

        btnLogout.setOnClickListener {
            s.setStatusLogin(false)
            // Navigate back to login screen
            findNavController().navigate(R.id.navigation_akun)
        }

        return view
    }
}