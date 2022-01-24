import androidx.compose.runtime.*
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLOptGroupElement
import org.w3c.dom.HTMLOptionElement
import org.w3c.dom.get

@Composable
fun SongCard(song: Api.Doc<Api.Song>) {
    var editing by mutableStateOf(false)
    val songDoc = song.doc.copy()
    val scope = rememberCoroutineScope()
    Form(attrs = {
        classes("row")
    }){
        Fieldset(attrs = {
            if(!editing) {
                attr("disabled", "true")
            }
        }){
            StrInput("Название", "name", song.doc.name) { songDoc.name = it}
            StrInput("Композитор", "composer", song.doc.composer)  { songDoc.composer = it}
            StrInput("Автор", "author_text", song.doc.author_text) { songDoc.author_text = it}
            StrInput("Жанр", "genry", song.doc.genry) { songDoc.genry = it}
            Select("Сезоны", "seasons", Data.seasons.map { it to it }, true, song.doc.seasons)  { songDoc.seasons = it}
            Select("Хоры", "choirs", Data.choirs.map { it to it }, true, song.doc.choirs) { songDoc.choirs = it}
            for ( (i,file) in song.doc.links.withIndex() ) {
                HiddenInput { name("links[$i]") ; value(file) }
            }
        }
        if(!editing)
            Div({
                classes("col-12")
            }){
                Button(attrs = {
                    type(ButtonType.Button)
                    classes("btn", "btn-primary")
                    onClick { editing = true }}) {
                    Text("Edit")
                }

            }
        else {
            Div({
                classes("col-12")
            }){
                Button(attrs = {
                    type(ButtonType.Button)
                    classes("btn", "btn-primary")
                    onClick {
                        scope.launch {
                            val newSong = song.copy(doc = songDoc)
                            Api.putSong(newSong)
                            State.songStatePusher(newSong)
                        }
                    }}) {
                    Text("Save")
                }
            }
        }

    }

}

@Composable
fun StrInput(label: String, name: String, defaultValue: String? = null, onChange: (String)->Unit) {
    var inputState by remember { mutableStateOf(defaultValue) }
    inputState = defaultValue
    Div({classes("mb-3")}){
        Label(attrs = {classes("form-label")}) { Text(label) }
        Input(InputType.Text) {
            name(name)
            classes("form-control")
            value(inputState ?: "")
            onInput { event -> inputState = event.value; onChange(event.value) }
//            placeholder(placeholder)
        }

    }
}
@Composable
fun Select(label: String, name: String, options: List<Pair<String, String>>, multi: Boolean, selected: List<String>? = null, onChange: (List<String>) -> Unit) {
    Div({classes("mb-3")}) {
        Label(attrs = { classes("form-label") }) { Text(label) }
        Select(attrs = {
            classes("form-select")
            name(name)
            if (multi)
                multiple()

            onChange {
                val opts = it.target.selectedOptions
                val values = (0 until opts.length).map {
                    val opt = opts[it] as HTMLOptionElement
                    opt.value
                }
                onChange(values)
            }
        }) {
            for (option in options) {
                Option(option.first, attrs = {
                    if (selected != null && option.first in selected)
                        selected()
                }) {
                    Text(option.second)
                }
            }
        }
    }
}