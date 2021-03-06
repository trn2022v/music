package com.example.myapplication.ui.music.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.data.network.service.artists.LastFMNetwork
import com.example.myapplication.data.network.service.artists.LastFMNetworkImpl
import com.example.myapplication.data.storage.preferances.AppPreferencesImpl
import com.example.myapplication.ui.auth.sign_in.fragment.AuthFragment
import com.example.myapplication.ui.music.AlbumsAdapter
import com.example.myapplication.ui.music.ArtistsAdapter
import com.example.myapplication.ui.music.ArtistsRecyclerItemDecoration
import com.example.myapplication.ui.music.MusicViewModel

class MusicFragment : Fragment() {

    private lateinit var viewModel: MusicViewModel
    private lateinit var profile: ImageButton
    private lateinit var albumBtn: AppCompatButton
    private lateinit var artistBtn: AppCompatButton
    private lateinit var recyclerArtists: RecyclerView
    private lateinit var recyclerAlbums: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.music_layout, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MusicViewModel::class.java]
        profile = view.findViewById(R.id.profile)
        albumBtn = view.findViewById(R.id.button_album)
        artistBtn = view.findViewById(R.id.button_artist)

        val lastFMNetwork = LastFMNetworkImpl.getInstance() as LastFMNetwork

        viewModel.setArtistService(lastFMNetwork.getArtistsService())
        viewModel.setAlbumsService(lastFMNetwork.getAlbumsService())
        viewModel.setSharedPreferences(AppPreferencesImpl.getInstance(requireContext()))

        lifecycle.addObserver(viewModel)

        recyclerAlbums = view.findViewById(R.id.recycler_albums)
        recyclerArtists = view.findViewById(R.id.recycler_artists)


        recyclerAlbums.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerAlbums.addItemDecoration(ArtistsRecyclerItemDecoration(16))



        recyclerArtists.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerArtists.addItemDecoration(ArtistsRecyclerItemDecoration(16))


        setListener()
        subscribeToLiveData()
    }

    private fun setListener() {
        profile.setOnClickListener {
            this.findNavController().navigate(R.id.action_musicFragment_to_profileFragment)
        }

    }

    private fun subscribeToLiveData() {

        viewModel.artistsLiveData.observe(viewLifecycleOwner) { artists ->
            recyclerArtists.adapter = ArtistsAdapter(artists) { artist ->
                println(artist)
            }
        }
        viewModel.albumsLiveData.observe(viewLifecycleOwner) { albums ->
            recyclerAlbums.adapter = AlbumsAdapter(albums) { album ->
                println(album)
            }
        }

        viewModel.logoutLiveData.observe(viewLifecycleOwner) {
            this.findNavController().navigate(R.id.action_musicFragment_to_authFragment2)
        }
    }
}