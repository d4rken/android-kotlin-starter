package eu.darken.androidkotlinstarter

import android.app.Service

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ServiceKey
import dagger.multibindings.IntoMap
import eu.darken.androidkotlinstarter.main.core.service.ExampleService
import eu.darken.androidkotlinstarter.main.core.service.ExampleServiceComponent

@Module(subcomponents = arrayOf(ExampleServiceComponent::class))
internal abstract class ServiceBinderModule {

    @Binds
    @IntoMap
    @ServiceKey(ExampleService::class)
    internal abstract fun exampleService(impl: ExampleServiceComponent.Builder): AndroidInjector.Factory<out Service>
}