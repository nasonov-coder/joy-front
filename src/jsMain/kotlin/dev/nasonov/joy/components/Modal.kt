package dev.nasonov.joy.components

import androidx.compose.runtime.*
import dev.nasonov.joy.components.utils.Icon
import dev.nasonov.joy.components.utils.Spinner
import dev.nasonov.joy.model.State
import dev.nasonov.joy.utils.Api
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.disabled
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.css.selectors.CSSSelector.PseudoClass.scope
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLDivElement

@Composable
fun Modal(song: Api.Doc<Api.Song>?, id: String) {
    var editing by mutableStateOf(false)
    val scope = rememberCoroutineScope()
    var newSongDoc: Api.Song? by mutableStateOf(null)
    var saving by mutableStateOf(false)
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
            if(song == null)
                return@Div
            Div(attrs = {
                classes("modal-content")
            }) {
                Div(attrs = {
                    classes("modal-header")
                }) {
                        H5(attrs = {
                            classes("modal-title")
                        }) {
                            Text(song.doc.name)
                            if (!editing)
                                A(attrs = {
                                    classes("link-primary", "mx-3", "fw-light")
                                    onClick {
                                        it.preventDefault()
                                        editing = true
                                    }
                                }) {
                                    Text("Edit")
                                }
                        }






                    Button(attrs = {
                        type(ButtonType.Button)
                        classes("btn-close")
                        attr("data-bs-dismiss", "modal")
                        attr("aria-label", "Close")
                    }) {}

                }
                Div(attrs = {
                    classes("modal-body")
                }) {

                    SongCard(song, editing, onChange = {
                        newSongDoc = it
                    })

                }
                Div(attrs = {
                    classes("modal-footer")
                }) {
                    Button(attrs = {
                        type(ButtonType.Button)
                        classes("btn", "btn-secondary")
                        attr("data-bs-dismiss", "modal")
                    }) {
                        Text("Close")

                    }
                    if(newSongDoc != null )
                        Button(attrs = {
                            attr("type", "button")
                            classes("btn", "btn-primary")
                            if(saving)
                                disabled()
                            onClick {
                                saving = true
                                scope.launch {
                                    val newSong = song.copy(doc = newSongDoc!!)
                                    Api.putSong(newSong)
                                    State.songStatePusher(newSong)
                                    saving = false
                                }
                            }
                        }) {
                            if(saving) {
                                Spinner()
                                Text(" Saving")
                            } else {
                                Text("Save changes")
                            }
                        }

                }

            }

        }

    }
}
