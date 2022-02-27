package com.triaaprilia.intent

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    val username: String?,
    val email: String?,
    val phoneNumber: String
):Parcelable
