package dev.nasonov.joy.components.utils

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*

@Composable
fun PlaceholderTable(rows: Int, cols: List<Int>, title: Boolean = true) {

//    require(cols.sum() <= 12)
    if(title) {
        Div(attrs = {
            classes("placeholder-glow", "container", "mt-3" )
        }) {
            H4(attrs = {
                classes("col-3", "placeholder")
            }) {

            }
        }
    }
    Div(attrs = {
        classes("placeholder-glow", "container" )
    }) {

        for (i in 0..rows) {
            for (j in cols) {
                Span(attrs = {
                    classes("placeholder", "col-$j", "placeholder-xs")
                }) {}
                Text(" ")
            }
        }
    }

}
