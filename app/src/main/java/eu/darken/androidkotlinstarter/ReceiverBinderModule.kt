package eu.darken.androidkotlinstarter

import android.content.BroadcastReceiver

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.BroadcastReceiverKey
import dagger.multibindings.IntoMap
import eu.darken.androidkotlinstarter.main.core.receiver.ExampleReceiver
import eu.darken.androidkotlinstarter.main.core.receiver.ExampleReceiverComponent

@Module(subcomponents = arrayOf(ExampleReceiverComponent::class))
internal abstract class ReceiverBinderModule {

    @Binds
    @IntoMap
    @BroadcastReceiverKey(ExampleReceiver::class)
    internal abstract fun exampleReceiver(impl: ExampleReceiverComponent.Builder): AndroidInjector.Factory<out BroadcastReceiver>

}