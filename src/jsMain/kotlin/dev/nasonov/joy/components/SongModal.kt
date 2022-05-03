package dev.nasonov.joy.components

import androidx.compose.runtime.*
import app.softwork.bootstrapcompose.*
import dev.nasonov.joy.components.utils.Spinner
import dev.nasonov.joy.components.utils.unaryPlus
import dev.nasonov.joy.model.State
import dev.nasonov.joy.utils.Api
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.dom.*
import dev.nasonov.joy.components.utils.overloading.Button as MyButton

@Composable
fun SongModal(song: Api.Doc<Api.Song>?, onDismissRequest: () -> Unit) {
//    var incomingReq by remember { mutableStateOf(onDismissRequest) }
//    var incomingSong by remember { println("remebering"); mutableStateOf(song) }
//    println("recomposition modal, ${song == incomingSong}, ${onDismissRequest == incomingReq}")
//    incomingSong = song
//    incomingReq= onDismissRequest
    var editing by mutableStateOf(false)
    var saving by mutableStateOf(false)
    var newSongDoc: Api.Song? by remember { mutableStateOf(null) }
    val scope = rememberCoroutineScope()
    if(song == null)
        return
    Modal(
        song.doc.name,
        onDismissRequest = onDismissRequest,
        content = {
            SongCard(newSongDoc?:song.doc, editing, onChange = {
                newSongDoc = it
            })
        },
        footer = {
            Button(
                "Close",
                color = Color.Secondary
            ) {
                onDismissRequest()
            }
            if(!editing)
                Button("Edit") {
                    editing = true
                }
            else
                MyButton(
                    disabled = saving,
                    action = {
                        saving = true
                        scope.launch {
                            val newSong = song.copy(doc = newSongDoc!!)
                            Api.putSong(newSong)
                            State.songStatePusher(newSong)
                            State.toast { showToast("saved") }
                            saving = false
                    }
                }) {
                    if(saving) {
                        Spinner()
                        +" Saving"
                    } else {
                        +"Save changes"
                    }
                }
        }
    )
}

