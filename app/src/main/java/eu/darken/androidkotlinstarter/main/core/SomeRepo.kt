package eu.darken.androidkotlinstarter.main.core

import eu.darken.androidkotlinstarter.main.ui.MainActivityComponent
import io.reactivex.Single
import java.util.*
import javax.inject.Inject


@MainActivityComponent.Scope
class SomeRepo @Inject
constructor() {

    val isShowFragment: Boolean
        get() = true

    val emoji: Single<String>
        get() = Single.create { emitter -> emitter.onSuccess(EMOJIS[(Math.random() * EMOJIS.size).toInt()]) }

    companion object {
        internal val EMOJIS = Arrays.asList("\uD83D\uDE00", "\uD83D\uDE02", "\uD83E\uDD17", "\uD83D\uDE32")
    }
}
