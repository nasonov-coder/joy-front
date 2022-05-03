package dev.nasonov.joy.components.utils

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.ElementScope
import org.jetbrains.compose.web.dom.Text


@Composable
operator fun String.unaryPlus() {
    Text(this)
}