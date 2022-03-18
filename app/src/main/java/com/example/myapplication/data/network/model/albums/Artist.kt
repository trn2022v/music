package com.example.myapplication.data.network.model.albums

import com.google.gson.annotations.SerializedName

data class Artist (

	@SerializedName("name") val name : String,
	@SerializedName("mbid") val mbid : String,
	@SerializedName("url") val url : String
)