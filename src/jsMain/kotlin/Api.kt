import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.Serializable

object Api {
    var endpoint = "http://localhost:80"
    private val jsonClient = HttpClient {
        install(JsonFeature) { serializer = KotlinxSerializer() }
    }
    @Serializable
    data class Doc<T>(
        val id: String,
        val type: String,
        val doc: T,
    )
    @Serializable
    data class Song(
        var name: String,
        var composer: String?,
        var author_text: String?,
        var links: List<String>,
        var seasons: List<String>,
        var choirs: List<String>,
        var genry: String?
    )
    suspend fun getSongList(): List<Doc<Song>> {
        return jsonClient.get("$endpoint/song/list")
    }
    suspend fun putSong(song: Doc<Song>) {
        return jsonClient.put("$endpoint/song/${song.id}") {
            contentType(ContentType.Application.Json)
            body = song.doc
        }
    }
}