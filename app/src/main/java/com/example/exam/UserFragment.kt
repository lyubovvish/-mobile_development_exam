package com.example.exam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.exam.databinding.FragmentUserBinding

class UserFragment : Fragment() {

    private lateinit var binding: FragmentUserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserBinding.inflate(inflater, container, false)

        val bundle = arguments
        binding.userName.text = bundle!!.getString("name")
        binding.userSurname.text = bundle.getString("surname")
        binding.userPicture.setImageResource(bundle.getInt("picture"))

        binding.button.setOnClickListener {
            activity?.onBackPressed()
        }

        binding.info.setOnClickListener{
            val name = bundle!!.getString("name")
            Toast.makeText(
                requireContext(),
                "This is $name",
                Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }

}