import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
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
        val name: String,
        val composer: String?,
        val author_text: String?,
        val links: List<String>,
        val seasons: List<String>,
        val choirs: List<String>,
        val genry: String?
    )
    suspend fun getSongList(): List<Doc<Song>> {
        return jsonClient.get("$endpoint/song/list")
    }
}