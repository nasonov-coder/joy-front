package dev.nasonov.joy.components

import androidx.compose.runtime.Composable
import dev.nasonov.joy.utils.Api
import dev.nasonov.joy.utils.external.opensheetmusicdisplay
import org.jetbrains.compose.web.dom.Div

@Composable
fun FilePage() {
//    var state by remember { mutableStateOf<File?>(null) }
//    dev.nasonov.joy.State.songStatePusher = {
//        state = state.toMutableMap().apply{ set(it.id, it) }
//    }
//    LaunchedEffect(Unit) { //todo unit?
//         dev.nasonov.joy.utils.Api.downloadFile("")
//    }
//    dev.nasonov.joy.SongList(state.values.toList())
    Div({ id("kekek"); }) {
        this.DomSideEffect {
            val o = opensheetmusicdisplay.OpenSheetMusicDisplay("keke").apply {
                load("${Api.endpoint}/file").then {
                    render()
                }
            }


        }
    }

}