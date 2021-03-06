package eu.darken.androidkotlinstarter.main.ui


import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import eu.darken.androidkotlinstarter.main.ui.fragment.ExampleFragment
import eu.darken.androidkotlinstarter.main.ui.fragment.ExampleFragmentComponent
import eu.darken.mvpbakery.injection.PresenterComponent
import eu.darken.mvpbakery.injection.activity.ActivityComponent
import eu.darken.mvpbakery.injection.fragment.FragmentKey

@MainActivityComponent.Scope
@Subcomponent(modules = arrayOf(MainActivityComponent.FragmentBinderModule::class))
interface MainActivityComponent : ActivityComponent<MainActivity>, PresenterComponent<MainActivityPresenter, MainActivityComponent> {

    @Subcomponent.Builder
    abstract class Builder : ActivityComponent.Builder<MainActivity, MainActivityComponent>()

    @javax.inject.Scope
    @Retention(AnnotationRetention.RUNTIME)
    annotation class Scope

    @Module(subcomponents = arrayOf(ExampleFragmentComponent::class))
    abstract class FragmentBinderModule {

        @Binds
        @IntoMap
        @FragmentKey(ExampleFragment::class)
        internal abstract fun exampleFragment(impl: ExampleFragmentComponent.Builder): AndroidInjector.Factory<out androidx.fragment.app.Fragment>

    }
}
