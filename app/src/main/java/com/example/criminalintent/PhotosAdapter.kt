package com.example.criminalintent

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.criminalintent.databinding.ActivityMainBinding
import com.example.criminalintent.databinding.PhotoItemBinding
import com.squareup.picasso.Picasso

class PhotosAdapter(var photos: List<IntentModel>) : RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder>() {

    class PhotoViewHolder(private val binding: PhotoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(photos: IntentModel) {
            binding.photoTitle.text = photos.title
            Picasso.get()
                .load(photos.url_s)
                .placeholder(R.drawable.sample_bitmap)
                .resize(250, 250)
                .into(binding.photoImage)
            binding.photoDescription.text = photos.url_s
            binding.photoOwner.text = photos.owner
            binding.photoTags.text = photos.secret
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = PhotoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = photos[position]
        holder.bind(photo)

    }

    override fun getItemCount(): Int {
        return photos.size
    }
}
