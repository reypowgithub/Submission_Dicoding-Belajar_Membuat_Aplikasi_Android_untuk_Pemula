package com.example.ukmfairapk

import android.os.Parcelable
import android.provider.ContactsContract.Contacts.Photo
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UKM (
    val nama :String,
    val description : String,
    val photo: Int,
    val kategori : String,
    val sosmed : String,
    val alamat : String,
    val juara : String,
    ):Parcelable