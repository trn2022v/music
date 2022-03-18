package com.example.myapplication.ui.music

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.data.network.model.albums.Album


class AlbumsAdapter(
    private val albums: List<Album>,
    private val albumSelected: (Album) -> Unit
) :
    RecyclerView.Adapter<AlbumsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.album_item, parent, false),
            albumSelected
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setArtist(albums[position])
    }

    override fun getItemCount(): Int = albums.size

    class ViewHolder(private val view: View, private val artistSelected: (Album) -> Unit) :
        RecyclerView.ViewHolder(view) {
        private var image: AppCompatImageView = view.findViewById(R.id.image_album)
        private var title: AppCompatTextView = view.findViewById(R.id.text_album_title)
        private var albums: Album? = null

        init {
            view.setOnClickListener {
                albums?.let {
                    artistSelected(it)
                }
            }
        }

        fun setArtist(album: Album) {
            Glide.with(view.context)
                .load(album.image.last().text)
                .into(image)

            title.text = album.name
        }
    }


}
