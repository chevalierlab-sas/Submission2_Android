package com.silvy

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val name : String?,
    val email : String?,
    val phone : String
) : Parcelable
