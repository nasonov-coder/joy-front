package dev.nasonov.joy.components.utils

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun Alert(text: String) {

    Div(attrs = {
        classes("alert", "alert-danger", "d-flex", "align-items-center", "mt-3")
        attr("role", "alert")
    }) {
        Icon.Alert("fa-2x", "me-2")
        Div {
            Text(" $text ")

        }
    }
}
