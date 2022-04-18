package dev.nasonov.joy.components.utils

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.I

@Composable
fun Icon(name: String, vararg classes: String) {
    I(attrs = {
        classes("far", "fa-$name", *classes)
    }) {

    }
}

object Icon {
    @Composable
    fun Pdf() = Icon("file-pdf")

    @Composable
    fun Edit() = Icon("edit")

    @Composable
    fun Alert(vararg classes: String) = Icon("exclamation-triangle", *classes)




}