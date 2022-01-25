package dev.nasonov.joy.components

import androidx.compose.runtime.*

import androidx.compose.runtime.remember
import dev.nasonov.joy.utils.Api
import dev.nasonov.joy.model.State

@Composable
fun SongListPage() {
    var state by remember { mutableStateOf<Map<String, Api.Doc<Api.Song>>>(mapOf()) }
    State.songStatePusher = {
        state = state.toMutableMap().apply{ set(it.id, it) }
    }
    LaunchedEffect(Unit) { //todo unit?
        state = Api.getSongList().associateBy { it.id }
    }
    SongList(state.values.toList(), null)
}