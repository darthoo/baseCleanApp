package com.arentator.arentator.utils

import android.content.res.Resources
import android.util.DisplayMetrics

/**
 * Created by Nikolay on 03.03.2018.
 */
object PixelConverter {
    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     *
     * @param dp A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * @return A int value to represent px equivalent to dp depending on device density
     */
    fun convertDpToPixel(dp: Int): Int {
        return (dp * (Resources.getSystem().displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)).toInt()
    }

    /**
     * This method converts device specific pixels to density independent pixels.
     *
     * @param px A value in px (pixels) unit. Which we need to convert into db
     * @return A int value to represent dp equivalent to px value
     */
    fun convertPixelsToDp(px: Int): Int {
        return (px / (Resources.getSystem().displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)).toInt()
    }
}