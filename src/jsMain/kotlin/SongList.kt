import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun SongList(list: List<Api.Doc<Api.Song>>) {
    println("song list")
    H1 { Text("Song list") }
    for (song in list) {
        Div {
            Text(song.doc.name)
        }
    }
    P { Text("total ${list.size}") }
}