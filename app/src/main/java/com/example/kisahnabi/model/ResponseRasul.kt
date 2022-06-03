package com.example.kisahnabi.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseRasul(

	@Json(name="ResponseRasul")
	val responseRasul: List<ResponseRasulItem?>? = null
) : Parcelable

@Parcelize
data class ResponseRasulItem(

	@Json(name="usia")
	val usia: String? = null,

	@Json(name="createdAt")
	val createdAt: String? = null,

	@Json(name="tempat")
	val tempat: String? = null,

	@Json(name="nama")
	val nama: String? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="avatar")
	val avatar: String? = null,

	@Json(name="deskripsi")
	val deskripsi: String? = null,

	@Json(name="id")
	val id: String? = null,

	@Json(name="tp_kelahiran")
	val tpKelahiran: String? = null
) : Parcelable
