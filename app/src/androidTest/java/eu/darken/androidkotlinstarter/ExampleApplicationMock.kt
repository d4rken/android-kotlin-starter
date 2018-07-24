package eu.darken.androidkotlinstarter

import android.app.Activity

import eu.darken.mvpbakery.injection.ManualInjector

class ExampleApplicationMock : App() {

    fun setActivityComponentSource(injector: ManualInjector<Activity>) {
        this.activityInjector = injector
    }
}
