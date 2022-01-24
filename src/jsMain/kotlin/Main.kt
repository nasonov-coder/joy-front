import androidx.compose.runtime.*
import app.softwork.routingcompose.HashRouter
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable
object State {
    var songStatePusher: (Api.Doc<Api.Song>)->Unit = {}
}
@Composable
fun SongListPage() {
    var state by remember { mutableStateOf<Map<String, Api.Doc<Api.Song>>>(mapOf()) }
    State.songStatePusher = {
        state = state.toMutableMap().apply{ set(it.id, it) }
    }
    LaunchedEffect(Unit) { //todo unit?
        state = Api.getSongList().associateBy { it.id }
    }
    SongList(state.values.toList())
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


