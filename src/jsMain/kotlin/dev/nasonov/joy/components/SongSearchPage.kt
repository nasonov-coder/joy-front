package dev.nasonov.joy.components

import androidx.compose.runtime.*
import app.softwork.bootstrapcompose.Alert
import dev.nasonov.joy.components.utils.Alert
import dev.nasonov.joy.components.utils.Container
import dev.nasonov.joy.components.utils.PlaceholderTable
import dev.nasonov.joy.utils.Api
import dev.nasonov.joy.model.State

@Composable
fun SongSearchPage(search: String?) {
    var state by remember { mutableStateOf<List<SearchGroupEntry>?>(null) }
    State.songStatePusher = {
//        state = state.toMutableMap().apply{ set(it.id, it) } //todo
    }

    if(search == null) {
        Container {
            Alert("Empty search")
        }
        return
    }
    LaunchedEffect(search) {
        state = Api.searchSong(search).filter { it.value.isNotEmpty() }.map { SearchGroupEntry(it.key, it.value) }
    }
    if(state==null) {
        PlaceholderTable(10, listOf(1, 2, 3, 3, 2) )
        PlaceholderTable(10, listOf(1, 2, 3, 3, 2) )
        PlaceholderTable(10, listOf(1, 2, 3, 3, 2) )
        PlaceholderTable(10, listOf(1, 2, 3, 3, 2) )
        PlaceholderTable(10, listOf(1, 2, 3, 3, 2) )
    } else {
        if (state!!.isEmpty())
            Container {
                Alert("No Hits")
            }
        for (i in state!!) {
            SongList(i.list, i.title)
        }
    }

}

data class SearchGroupEntry(
    val title: String,
    val list:List<Api.Doc<Api.Song>>
)