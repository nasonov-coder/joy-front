package dev.nasonov.joy.components.utils

import androidx.compose.runtime.*

import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.name
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Label
import org.jetbrains.compose.web.dom.Text

@Composable
fun StrInput(label: String, name: String, defaultValue: String? = null, onChange: (String)->Unit) {
    var inputState by remember { mutableStateOf(defaultValue) }
    inputState = defaultValue
    Div({ classes("mb-3") }) {
        Label(attrs = { classes("form-label") }) { +label }
        Input(InputType.Text) {
            name(name)
            classes("form-control")
            value(inputState ?: "")
            onInput { event -> inputState = event.value; onChange(event.value) }
//            placeholder(placeholder)
        }

    }
}