package eu.darken.androidkotlinstarter.main.ui

import eu.darken.androidkotlinstarter.main.core.SomeRepo
import eu.darken.mvpbakery.base.Presenter
import eu.darken.mvpbakery.injection.ComponentPresenter
import javax.inject.Inject

class MainActivityPresenter @Inject
constructor(private val someRepo: SomeRepo) : ComponentPresenter<MainActivityPresenter.View, MainActivityComponent>() {

    override fun onBindChange(view: View?) {
        super.onBindChange(view)
        withView { v ->
            if (someRepo.isShowFragment) {
                v.showExampleFragment()
            }
        }
    }

    interface View : Presenter.View {
        fun showExampleFragment()
    }
}
