package com.example.myapplication.data.network.model.albums

import com.google.gson.annotations.SerializedName



data class Image (

	@SerializedName("#text") val text : String,
	@SerializedName("size") val size : String
)