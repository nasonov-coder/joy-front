package dev.nasonov.joy.components.utils

import androidx.compose.runtime.Composable
import app.softwork.bootstrapcompose.Color
import app.softwork.bootstrapcompose.Layout.HorizontalAlignment.*
import app.softwork.bootstrapcompose.Layout.Display.*
import app.softwork.bootstrapcompose.SpacingSpecs
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import app.softwork.bootstrapcompose.SpacingSpecs.SpacingSize.*

@Composable
fun Alert(text: String) {

    app.softwork.bootstrapcompose.Alert(Color.Danger, styling = {
        Layout {
            display(app.softwork.bootstrapcompose.Layout.Display.Flex)
            horizontalAlignment = Center
        }
        Margins {
            Top {
                size = Medium
            }
        }

    }) {
        Icon.Alert("fa-2x", "me-2")
        Div {
            +" $text "
        }
    }
//    Div(attrs = {
//        classes("alert", "alert-danger", "d-flex", "align-items-center", "mt-3")
//        attr("role", "alert")
//    }) {
//
//    }
}
