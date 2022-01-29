package com.example.exam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val verticalLinearLayoutManager: LinearLayoutManager =
        LinearLayoutManager(this, RecyclerView.VERTICAL, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userFragment = UserFragment()

        binding.recyclerView.layoutManager = verticalLinearLayoutManager
        binding.recyclerView.adapter = UsersAdapter(DataHolder.dataList) { name, surname, picture ->
            val bundle = Bundle()

            bundle.putString("name", name)
            bundle.putString("surname", surname)
            bundle.putInt("picture", picture)
            userFragment.arguments = bundle

            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, userFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}