package com.salim.githubuserv1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Detail(
    var name: String?,
    var username: String?,
    var photo: Int?,
    var location: String?,
    var repository: String?,
    var company: String?,
    var followers: String?,
    var following: String?
) : Parcelable
