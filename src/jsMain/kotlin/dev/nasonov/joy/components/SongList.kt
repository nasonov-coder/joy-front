package dev.nasonov.joy.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.*

import dev.nasonov.joy.utils.Api
import org.jetbrains.compose.web.dom.*

@Composable
fun SongList(list: List<Api.Doc<Api.Song>>, title: String?) {
    var modalSong by remember { mutableStateOf<Api.Doc<Api.Song>?>(null) }
//    var modalOpened by remember { mutableStateOf(false) }
    Div({ classes("container") }) {
        H4 { Text((title ?: "Song list") + "(${list.size})") }

        Table({ classes("table", "table-hover", "table-striped") }) {
            Thead {
                Tr {
                    Th({ attr("scope", "col") }) { Text("Название") }
                    Th({ attr("scope", "col") }) { Text("Композитор") }
                    Th({ attr("scope", "col") }) { Text("Жанр") }
                    Th({ attr("scope", "col") }) { Text("Хоры") }
                    Th({ attr("scope", "col") }) { Text("Сезоны") }
                }
            }
            Tbody {
                for (song in list) {
                    Tr({
                        onClick { modalSong = song }
                        attr("data-bs-toggle", "modal")
                        attr("data-bs-target", "#myModal")
                    }) {
                        Td/*({ attr("scope", "row") })*/ { Text(song.doc.name) }
                        Td { Text(song.doc.composer ?: "") }
                        Td { Text(song.doc.genry ?: "") }
                        Td { Text(song.doc.choirs.joinToString()) }
                        Td { Text(song.doc.seasons.joinToString()) }
                    }
                }
            }
        }
    }
    Modal(modalSong, "myModal")



}