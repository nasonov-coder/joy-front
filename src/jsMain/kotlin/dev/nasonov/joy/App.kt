package dev.nasonov.joy

import app.softwork.routingcompose.HashRouter
import dev.nasonov.joy.components.AppHeader
import dev.nasonov.joy.components.SongListPage
import dev.nasonov.joy.components.SongSearchPage
import dev.nasonov.joy.components.utils.Icon
import dev.nasonov.joy.utils.external.decodeURIComponent
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable

fun main() {
//    var count: Int by mutableStateOf(0)

    renderComposable(rootElementId = "root") {
        Div {
            HashRouter(initRoute = "/") {
                // or BrowserRouter(initRoute = "/users") {
                AppHeader()

                route("/users") {
                    int { userID ->
                        Text("User with $userID")
                    }
                    noMatch {
                        Text("User list")
                    }
                }
                route("/song") {
                    route("/list") {
                        SongListPage()
                    }
                    route("/search") {

                        val search = parameters?.map?.get("search")?.first()

                        SongSearchPage(search?.let { decodeURIComponent(it) })

                    }
                }
                route("/file") {

                }
                noMatch {
                    Text("404!!!")
                    Icon.Pdf()
//                    dev.nasonov.joy.FilePage()
                }
            }

        }
//        Div({ style { padding(25.px) } }) {
//            Button(attrs = {
//                onClick { count -= 1 }
//            }) {
//                Text("-")
//            }
//
//            Span({ style { padding(15.px) } }) {
//                Text("$count")
//            }
//
//            Button(attrs = {
//                onClick { count += 1 }
//                classes("")
//            }) {
//                Text("+")
//            }
//            Table {
//                Tr {
//                    Td {
//                        Text("t1")
//                    }
//                }
//            }
//        }
    }
}


