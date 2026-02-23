package com.neilturner.aerialviews.utils

import android.content.Context
import android.graphics.Typeface
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.TypefaceCompat
import com.neilturner.aerialviews.R
import timber.log.Timber

object FontHelper {
    fun getTypeface(
        context: Context,
        typeface: String,
        weight: String,
    ): Typeface =
        getTypeface(
            context,
            typeface,
            weight.toInt(),
        )

    fun getTypeface(
        context: Context,
        typeface: String,
        weight: Int,
    ): Typeface {
        val font =
            try {
                when (typeface) {
                    "open-sans" -> ResourcesCompat.getFont(context, R.font.opensans)
                    "mi-sans" -> ResourcesCompat.getFont(context, R.font.misans)
                    else -> Typeface.create("sans-serif", Typeface.NORMAL)
                }
            } catch (ex: Exception) {
                Timber.e(ex)
                Typeface.create("sans-serif", Typeface.NORMAL)
            }
        return TypefaceCompat.create(context, font, weight, false)
    }
}