import androidx.compose.runtime.*
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.fontWeight
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLDivElement

@Composable
fun SongList(list: List<Api.Doc<Api.Song>>) {
    var modalSong by remember { mutableStateOf<Api.Doc<Api.Song>?>(null) }
//    var modalOpened by remember { mutableStateOf(false) }
    Div({ classes("container") }) {
//        H3 { Text("Song list") }

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

        P { Text("total ${list.size}") }
    }
    Modal(modalSong, "myModal")



}

@Composable
fun Modal(song: Api.Doc<Api.Song>?, id: String) {
    Div(attrs = {
        id(id)
        classes("modal", "fade")
        attr("tabindex", "-1")
//        addEventListener("hide.bs.modal") {
//            onCloseCallback()
//        }
    }) {

        Div(attrs = {
            classes("modal-dialog")
        }) {
            Div(attrs = {
                classes("modal-content")
            }) {
                Div(attrs = {
                    classes("modal-header")
                }) {
                    H5(attrs = {
                        classes("modal-title")
                    }) {
                        Text(song?.doc?.name ?: "")

                    }
                    Button(attrs = {
                        attr("type", "button")
                        classes("btn-close")
                        attr("data-bs-dismiss", "modal")
                        attr("aria-label", "Close")
                    }) {}

                }
                Div(attrs = {
                    classes("modal-body")
                }) {
                    if(song != null) {
                        SongCard(song)
                    }
                }
                Div(attrs = {
                    classes("modal-footer")
                }) {
                    Button(attrs = {
                        attr("type", "button")
                        classes("btn", "btn-secondary")
                        attr("data-bs-dismiss", "modal")
                    }) {
                        Text("Close")

                    }
                    Button(attrs = {
                        attr("type", "button")
                        classes("btn", "btn-primary")
                    }) {
                        Text("Save changes")

                    }

                }

            }

        }

    }
}
