package com.arentator.arentator.adapter

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View
import com.arentator.arentator.utils.PixelConverter

/**
 * Created by Nikolay on 03.03.2018.
 */
class VerticalDivider(private val verticalSpaceHeight: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView,
                                state: RecyclerView.State?) {
        outRect.bottom = PixelConverter.convertDpToPixel(verticalSpaceHeight)
    }
}