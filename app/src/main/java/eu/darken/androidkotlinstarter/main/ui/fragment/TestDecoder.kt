package eu.darken.androidkotlinstarter.main.ui.fragment

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v4.graphics.drawable.DrawableCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.Options
import com.bumptech.glide.load.ResourceDecoder
import com.bumptech.glide.load.engine.Resource
import com.bumptech.glide.load.resource.SimpleResource

class TestDecoder(private val context: Context, glide: Glide) : ResourceDecoder<String, Drawable> {

    override fun handles(source: String, options: Options): Boolean {
        return true
    }

    override fun decode(ownerInfo: String, _width: Int, _height: Int, options: Options): Resource<Drawable>? {
        var drawable = ContextCompat.getDrawable(context, android.R.drawable.ic_menu_camera)
        drawable = DrawableCompat.wrap(drawable!!)
        drawable = drawable!!.mutate()
        DrawableCompat.setTint(drawable, Color.RED)
        return SimpleResource(drawable!!)

    }

}
