package com.bangkit.rextra

import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

@BindingAdapter("imageUrl")
fun loadImage(view: CircleImageView, url: String?) {
    url?.let {
        Glide.with(view.context)
            .load(url)
            .into(view)
    }
}
