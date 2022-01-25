package dev.nasonov.joy.components.utils

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.I

@Composable
fun Icon(name: String) {
    I(attrs = {
        classes("far", "fa-$name")
    }) {

    }
}

object Icon {
    @Composable
    fun Pdf() = Icon("file-pdf")
}