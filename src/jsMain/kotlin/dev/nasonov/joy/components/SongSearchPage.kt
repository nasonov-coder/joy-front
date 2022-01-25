package dev.nasonov.joy.components

import androidx.compose.runtime.*
import dev.nasonov.joy.utils.Api
import dev.nasonov.joy.model.State
import org.jetbrains.compose.web.dom.Text

@Composable
fun SongSearchPage(search: String?) {
    var state by remember { mutableStateOf<List<SearchGroupEntry>>(listOf()) }
    State.songStatePusher = {
//        state = state.toMutableMap().apply{ set(it.id, it) } //todo
    }
    if(search == null) {
        Text("Empty search")
        return
    }
    LaunchedEffect(search) {
        println("searchin $search")
        state = Api.searchSong(search).filter { it.value.isNotEmpty() }.map { SearchGroupEntry(it.key, it.value) }
    }
    if( state.isEmpty() )
        Text("No hits")
    for( i in state ) {
        SongList(i.list, i.title)
    }

}

data class SearchGroupEntry(
    val title: String,
    val list:List<Api.Doc<Api.Song>>
)