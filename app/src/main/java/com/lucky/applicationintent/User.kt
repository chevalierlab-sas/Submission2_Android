package com.lucky.applicationintent
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val name: String?,
    val email: String?,
    val telepon: String?
):Parcelable

