package com.example.appretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appretrofit.databinding.UsersListLayoutBinding
import com.example.appretrofit.models.allUsers.Data

class RecyclerAdapter(
    private val idListener: IOnclick
) :
    RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>() {
    val users = mutableListOf<Data?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView =
            UsersListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = ItemViewHolder(itemView)
        return holder
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = users.size

    inner class ItemViewHolder(private val binding: UsersListLayoutBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        private lateinit var model: Data

        fun bind() {
            model = users[adapterPosition]!!

            binding.tvId.text = model.id.toString()
            binding.tvName.text = model.firstName
            binding.tvEmail.text = model.email
            model.avatar?.let { binding.ivAvatar.loadImage(it) }

            binding.root.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            idListener.sendUserId(model.id)
        }
    }

    fun setData(country: MutableList<Data?>) {
        this.users.addAll(country)
        notifyDataSetChanged()
    }

    fun clearData() {
        this.users.clear()
        notifyDataSetChanged()
    }



}
