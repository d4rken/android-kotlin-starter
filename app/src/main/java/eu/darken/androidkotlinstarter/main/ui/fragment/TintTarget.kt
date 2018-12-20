package eu.darken.androidkotlinstarter.main.ui.fragment

import android.graphics.drawable.Drawable
import android.widget.ImageView

import com.bumptech.glide.request.target.ImageViewTarget

class TintTarget(view: ImageView) : ImageViewTarget<Drawable>(view) {

    override fun setResource(resource: Drawable?) {
        view.setImageDrawable(resource)
    }
}