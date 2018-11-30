package eu.darken.androidkotlinstarter

import android.app.Activity

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import eu.darken.androidkotlinstarter.main.ui.MainActivity
import eu.darken.androidkotlinstarter.main.ui.MainActivityComponent
import eu.darken.mvpbakery.injection.activity.ActivityKey

@Module(subcomponents = arrayOf(MainActivityComponent::class))
internal abstract class ActivityBinderModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    internal abstract fun main(impl: MainActivityComponent.Builder): AndroidInjector.Factory<out Activity>
}