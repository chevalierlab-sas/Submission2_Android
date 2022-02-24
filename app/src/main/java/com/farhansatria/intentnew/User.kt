package com.farhansatria.intentnew

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val userName: String?,
    val phoneNumber: String?,
    val email: String
): Parcelable
