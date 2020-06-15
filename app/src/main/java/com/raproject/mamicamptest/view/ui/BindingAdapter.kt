package com.raproject.mamicamptest.view.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("showCover")
fun showCover(imgView: ImageView, url: String?){
    Glide.with(imgView.context)
        .load("https://cabaca.id:8443/api/v2/files/$url&api_key=32ded42cfffb77dee86a29f43d36a3641849d4b5904aade9a79e9aa6cd5b5948")
        .into(imgView)
}