package dev.nasonov.joy.model

import app.softwork.bootstrapcompose.ToastContainerState
import dev.nasonov.joy.utils.Api

object State {
    var songStatePusher: (Api.Doc<Api.Song>)->Unit = {}
    var toastContainerState: ToastContainerState? = null
    fun toast(block: ToastContainerState.()->Unit) {
        toastContainerState?.apply(block) ?: error("toastContainerState is null")
    }
}