package dev.nasonov.joy

import app.softwork.routingcompose.HashRouter
import dev.nasonov.joy.components.AppHeader
import dev.nasonov.joy.components.SongListPage
import dev.nasonov.joy.components.SongSearchPage
import dev.nasonov.joy.components.utils.Icon
import dev.nasonov.joy.components.utils.unaryPlus
import dev.nasonov.joy.utils.external.decodeURIComponent
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable

fun main() {
//    var count: Int by mutableStateOf(0)

    renderComposable(rootElementId = "root") {
        Div {
            HashRouter(initRoute = "/") {
                // or BrowserRouter(initRoute = "/users") {


                route("/users") {
                    AppHeader()
                    int { userID ->
                        +"User with $userID"
                    }
                    noMatch {
                        +"User list"
                    }
                }
                route("/song") {
                    route("/list") {
                        AppHeader()
                        SongListPage()
                    }
                    route("/search") {
                        val search = parameters?.map?.get("search")?.first()?.let { decodeURIComponent(it) }
                        AppHeader(search)
                        SongSearchPage(search)
                    }
                }
                route("/file") {

                }
                noMatch {
                    +"404!!!"
//                    Icon.Pdf()
//                    dev.nasonov.joy.FilePage()
                }
            }

        }

    }
}


