package com.panjidwisatrio.intent

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val name: String?,
    val email: String?,
    val phoneNumber: String
): Parcelable
