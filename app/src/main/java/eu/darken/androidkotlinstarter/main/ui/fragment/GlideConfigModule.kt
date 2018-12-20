package eu.darken.androidkotlinstarter.main.ui.fragment

import android.content.Context
import android.graphics.drawable.Drawable

import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Priority
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions

@GlideModule
class GlideConfigModule : AppGlideModule() {

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        builder.setDefaultRequestOptions(RequestOptions
                .diskCacheStrategyOf(DiskCacheStrategy.NONE)
                .priority(Priority.LOW))
    }

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        registry.append(String::class.java, String::class.java, TestModelLoader.Factory(context))
        registry.append(String::class.java, Drawable::class.java, TestDecoder(context, glide))
    }

    override fun isManifestParsingEnabled(): Boolean {
        return false
    }
}
