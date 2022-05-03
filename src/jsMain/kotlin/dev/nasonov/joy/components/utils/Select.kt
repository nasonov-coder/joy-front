package dev.nasonov.joy.components.utils

import androidx.compose.runtime.*
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLOptionElement
import org.w3c.dom.get

@Composable
fun Select(label: String, name: String, options: List<Pair<String, String>>, multi: Boolean, selected: List<String>? = null, onChange: (List<String>) -> Unit) {
    Div({classes("mb-3")}) {
        Label(attrs = { classes("form-label") }) { +label }
        Select(attrs = {
            classes("form-select")
            name(name)
            if (multi)
                multiple()

            onChange {
                val opts = it.target.selectedOptions
                val values = (0 until opts.length).map {
                    val opt = opts[it] as HTMLOptionElement
                    opt.value
                }
                onChange(values)
            }
        }) {
            for (option in options) {
                Option(option.first, attrs = {
                    if (selected != null && option.first in selected)
                        selected()
                }) {
                    +option.second
                }
            }
        }
    }
}