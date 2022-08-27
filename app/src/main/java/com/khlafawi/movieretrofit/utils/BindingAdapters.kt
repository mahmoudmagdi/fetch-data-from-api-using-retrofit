package com.khlafawi.movieretrofit.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.khlafawi.movieretrofit.R
import com.khlafawi.movieretrofit.model.Movie
import com.khlafawi.movieretrofit.utils.Constants.POSTER_BASE_URL
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, movie: Movie) {
    val context = imageView.context
    if (movie.poster_path.isNotBlank()) {
        Picasso.with(context)
            .load(POSTER_BASE_URL + movie.poster_path)
            .placeholder(R.drawable.placeholder_picture)
            .error(R.drawable.no_image_available)
            .fit()
            .centerCrop()
            .into(imageView)
    } else {
        imageView.setImageResource(R.drawable.no_image_available)
        imageView.scaleType = ImageView.ScaleType.CENTER_INSIDE
    }

    val contentDescription = movie.title
    imageView.contentDescription = contentDescription
}