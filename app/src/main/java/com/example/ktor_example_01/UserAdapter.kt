package com.example.ktor_example_01

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.ktor_example_01.networking.dto.User


class UserAdapter(var items: List<User> = listOf()) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(parent)

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class UserViewHolder(
        parent: ViewGroup,
        private val rootView: View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_user,
            parent,
            false
        )
    ) : RecyclerView.ViewHolder(rootView) {

        @SuppressLint("SetTextI18n")
        fun bind(user: User) {

            rootView.apply {
                this.findViewById<TextView>(R.id.txtName).text = "${user.name.title} ${user.name.first} ${user.name.last} "
                this.findViewById<TextView>(R.id.txtGender).text = user.gender
                this.findViewById<TextView>(R.id.txtEmail).text = user.email
                this.findViewById<TextView>(R.id.txtPhone).text = user.phone

                Glide.with(this)
                    .load(user.picture.medium)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(this.findViewById<ImageView>(R.id.imageView))
            }
        }
    }
}