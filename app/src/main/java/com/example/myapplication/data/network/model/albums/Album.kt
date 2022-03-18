package com.example.myapplication.data.network.model.albums

import com.google.gson.annotations.SerializedName



data class Album (

	@SerializedName("name") val name : String,
	@SerializedName("mbid") val mbid : String,
	@SerializedName("url") val url : String,
	@SerializedName("artist") val artist : Artist,
	@SerializedName("image") val image : List<Image>,
	@SerializedName("@attr") val attrAlbums: AttrAlbums
)