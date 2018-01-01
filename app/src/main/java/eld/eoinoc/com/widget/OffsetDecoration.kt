package eld.eoinoc.com.widget

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by eoinoc on 30/12/2017.
 */
class OffsetDecoration(private val offset: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect,
                                view: View,
                                parent: RecyclerView,
                                state: RecyclerView.State?) {
        outRect.set(offset, offset, offset, offset)
    }
}