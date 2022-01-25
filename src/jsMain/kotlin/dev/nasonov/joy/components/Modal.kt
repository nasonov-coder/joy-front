package dev.nasonov.joy.components

import androidx.compose.runtime.*
import dev.nasonov.joy.utils.Api
import org.jetbrains.compose.web.dom.*

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
