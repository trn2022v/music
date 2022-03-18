package com.example.myapplication.data.network.model.albums

import Albums
import com.google.gson.annotations.SerializedName


data class AlbumsResponse (

	@SerializedName("albums") val albums : Albums
)