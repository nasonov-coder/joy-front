package dev.nasonov.joy.components

import androidx.compose.runtime.*
import dev.nasonov.joy.model.State
import dev.nasonov.joy.components.utils.StrInput
import dev.nasonov.joy.model.Data
import dev.nasonov.joy.utils.Api
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.name
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.dom.*

@Composable
fun SongCard(song: Api.Doc<Api.Song>) {
    var editing by mutableStateOf(false)
    val songDoc = song.doc.copy()
    val scope = rememberCoroutineScope()
    Form(attrs = {
        classes("row")
    }) {
        Fieldset(attrs = {
            if (!editing) {
                attr("disabled", "true")
            }
        }) {
            StrInput("Название", "name", song.doc.name) { songDoc.name = it }
            StrInput("Композитор", "composer", song.doc.composer) { songDoc.composer = it }
            StrInput("Автор", "author_text", song.doc.author_text) { songDoc.author_text = it }
            StrInput("Жанр", "genry", song.doc.genry) { songDoc.genry = it }
            dev.nasonov.joy.components.utils.Select(
                "Сезоны",
                "seasons",
                Data.seasons.map { it to it },
                true,
                song.doc.seasons
            ) { songDoc.seasons = it }
            dev.nasonov.joy.components.utils.Select(
                "Хоры",
                "choirs",
                Data.choirs.map { it to it },
                true,
                song.doc.choirs
            ) { songDoc.choirs = it }
            for ((i, file) in song.doc.links.withIndex()) {
                HiddenInput { name("links[$i]"); value(file) }
            }
        }
        if (!editing)
            Div({
                classes("col-12")
            }) {
                Button(attrs = {
                    type(ButtonType.Button)
                    classes("btn", "btn-primary")
                    onClick { editing = true }
                }) {
                    Text("Edit")
                }

            }
        else {
            Div({
                classes("col-12")
            }) {
                Button(attrs = {
                    type(ButtonType.Button)
                    classes("btn", "btn-primary")
                    onClick {
                        scope.launch {
                            val newSong = song.copy(doc = songDoc)
                            Api.putSong(newSong)
                            State.songStatePusher(newSong)
                        }
                    }
                }) {
                    Text("Save")
                }
            }
        }

    }

}