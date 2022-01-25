package dev.nasonov.joy.model

import dev.nasonov.joy.utils.Api

object State {
    var songStatePusher: (Api.Doc<Api.Song>)->Unit = {}
}