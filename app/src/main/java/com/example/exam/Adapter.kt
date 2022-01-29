package com.example.exam

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exam.databinding.ItemUsersBinding

class UsersAdapter(private val list: List<Data>, val item: (String, String, Int) -> Unit) :
    RecyclerView.Adapter<UsersAdapter.Holder>() {

    inner class Holder internal constructor(
        private val binding: ItemUsersBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Data) = binding.run {
            name.text = data.name
            surname.text = data.surname
            picture.setImageResource(data.pictureRes)
            bio.text = data.minimalInfo

            itemView.setOnClickListener { item(data.name, data.surname, data.pictureRes) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val picture = list[position]
        holder.bind(picture)
    }
}