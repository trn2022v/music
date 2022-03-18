package com.example.myapplication.data.network.model.albums

import com.google.gson.annotations.SerializedName

data class AttrAlbums (

	@SerializedName("tag") val tag : String,
	@SerializedName("page") val page : Int,
	@SerializedName("perPage") val perPage : Int,
	@SerializedName("totalPages") val totalPages : Int,
	@SerializedName("total") val total : Int
)