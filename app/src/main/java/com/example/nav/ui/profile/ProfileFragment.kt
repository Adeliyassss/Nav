package com.example.nav.ui.profile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.addTextChangedListener
import com.example.nav.R
import com.example.nav.data.remote.Pref
import com.example.nav.databinding.FragmentProfileBinding
import com.example.nav.utils.loadImage


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var pref: Pref


    val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode== Activity.RESULT_OK && it.data!=null){
            val image = it.data?.data
            pref.saveImg(image.toString())
            binding.imgProfile.loadImage(image.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref=Pref(requireContext())

        binding.etName.setText(pref.getUserName())
        binding.imgProfile.loadImage(pref.getImg())
        binding.etName.addTextChangedListener {
            pref.saveUserName(binding.etName.text.toString())
        }


        binding.imgProfile.setOnClickListener {
            val intent= Intent()
            intent.type="image/*"
            intent.action=Intent.ACTION_GET_CONTENT
            launcher.launch(intent)
        }
    }
}