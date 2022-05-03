package dev.nasonov.joy.components.utils

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.ContentBuilder
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLDivElement

@Composable
fun Container(
    attrs: AttrBuilderContext<HTMLDivElement>? = null,
    content: ContentBuilder<HTMLDivElement>? = null
) {

    Div(attrs = {
        classes("container-md")
        if (attrs != null) {
            attrs(this)
        }
    }) {
        if (content != null) {
            content(this)
        }
    }
}