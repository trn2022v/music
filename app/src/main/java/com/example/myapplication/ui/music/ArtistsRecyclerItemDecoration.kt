package com.example.myapplication.ui.music

import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ArtistsRecyclerItemDecoration(private val edgeOffset: Int = 0) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view)
        val itemCount = parent.adapter?.itemCount ?: 0

        outRect.right = 0
        outRect.left = 0

        when (position) {
            itemCount - 1 -> {
                outRect.right = TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, edgeOffset.toFloat(), view.context.resources.displayMetrics
                ).toInt()
                outRect.left = TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, edgeOffset.toFloat(), view.context.resources.displayMetrics
                ).toInt()
            }
            else -> {
                outRect.left = TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, edgeOffset.toFloat(), view.context.resources.displayMetrics
                ).toInt()
            }
        }
    }
}