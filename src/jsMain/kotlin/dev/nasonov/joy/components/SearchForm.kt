package dev.nasonov.joy.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import app.softwork.routingcompose.Router
import dev.nasonov.joy.components.utils.unaryPlus
import kotlinx.browser.window
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.onSubmit
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Form
import org.jetbrains.compose.web.dom.Input
import org.w3c.dom.HTMLFormElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.url.URL

@Composable
fun SearchForm(search: String?) {
    val router = Router.current
    var searchText by remember { mutableStateOf(search) }
    Form (attrs = {
        classes("d-flex")
        onSubmit {
            it.preventDefault()
            val k = it.target as HTMLFormElement
            val input = k.querySelector("input") as HTMLInputElement
            val search = input.value
            val url = URL(window.location.toString());
            url.hash = "/song/search"
            url.searchParams.set("search", search);
            router.navigate("${url.hash}${url.search}")
        }
    }) {
        Input(attrs = {
            value(searchText?:"")
            classes("form-control", "me-2")
            attr("placeholder","Search")
            attr("aria-label","Search")
            onInput { searchText = it.value }
        }, type = InputType.Search)
        Button (attrs = {
            classes("btn", "btn-outline-success")
            attr("type","submit")
        }){
            +"Search"
        }

    }
}