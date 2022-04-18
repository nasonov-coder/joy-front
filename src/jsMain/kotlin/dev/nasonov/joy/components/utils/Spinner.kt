package dev.nasonov.joy.components.utils

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun Spinner() {
    Span(attrs = {
        classes("spinner-border", "spinner-border-sm")
        attr("role", "status")
        attr("aria-hidden", "true")
    }) {}
}