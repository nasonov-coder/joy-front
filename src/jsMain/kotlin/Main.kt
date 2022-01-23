import androidx.compose.runtime.*
import app.softwork.routingcompose.HashRouter
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable

@Composable
fun SongListPage() {
    var count by mutableStateOf(0)
    var state by remember { mutableStateOf<List<Api.Doc<Api.Song>>>(listOf()) }
//                        val scope = rememberCoroutineScope()
    LaunchedEffect(Unit) { //todo unit?
        state = Api.getSongList()
        println(state)
        count ++
    }
    println("SongListPage, ${state?.size}")
    println("SongListPage, ${count}")

    SongList(state )
}
fun main() {
//    var count: Int by mutableStateOf(0)

    renderComposable(rootElementId = "root") {
        AppHeader()
        Div {
            HashRouter(initRoute = "/") {
                // or BrowserRouter(initRoute = "/users") {

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
                }
                noMatch {
                    Text("404!!!")
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


