package dev.nasonov.joy.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import dev.nasonov.joy.components.utils.Container
import dev.nasonov.joy.components.utils.unaryPlus

import dev.nasonov.joy.utils.Api
import org.jetbrains.compose.web.dom.*
import kotlin.reflect.KMutableProperty
import kotlin.reflect.KMutableProperty0
import kotlin.reflect.KProperty0

typealias Song = Api.Doc<Api.Song>
@Composable
fun SongList(list: List<Song>, title: String?) {
    var modalSong by remember { mutableStateOf<Song?>(null) }
    var showModal by remember { mutableStateOf(false) }


//    var modalOpened by remember { mutableStateOf(false) }
    Container {
        H4 { +((title ?: "Song list") + "(${list.size})") }

        Table({ classes("table", "table-hover", "table-striped") }) {
            Thead {
                Tr {
                    Th({ attr("scope", "col") }) { +"Название" }
                    Th({ attr("scope", "col") }) { +"Композитор" }
                    Th({ attr("scope", "col") }) { +"Жанр" }
                    Th({ attr("scope", "col") }) { +"Хоры" }
                    Th({ attr("scope", "col") }) { +"Сезоны" }
                }
            }
            Tbody {
                for (song in list) {
                    Tr({
                        onClick { modalSong = song; showModal = true }
                    }) {
                        Td/*({ attr("scope", "row") })*/ { +song.doc.name }
                        Td { +(song.doc.composer ?: "") }
                        Td { +(song.doc.genry ?: "") }
                        Td { +(song.doc.choirs.joinToString()) }
                        Td { +(song.doc.seasons.joinToString()) }
                    }
                }
            }
        }
    }
    if (showModal)
        SongModal(modalSong) {
            showModal = false
        }


}
