package advisor.services;

import advisor.entities.Album;
import advisor.entities.Playlist;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AdvServiceImpl extends AbstractService implements AdvService {

    private String accessToken;

    public AdvServiceImpl(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public List<Playlist> getFeaturedPlaylists() throws IOException, InterruptedException {
        JsonElement jsonElement = makeRequest(getApiServerPath() + "/v1/browse/featured-playlists");
        if (jsonElement == null) {
            return null;
        }
        return getPlaylistsByJsonElem(jsonElement);
    }

    @Override
    public List<Album> getNewReleases() throws IOException, InterruptedException {
        JsonElement jsonElement = makeRequest(getApiServerPath() + "/v1/browse/new-releases");
        JsonArray albumsJsonArr = jsonElement.getAsJsonObject()
                .getAsJsonObject("albums")
                .getAsJsonArray("items");
        List<Album> newReleases = new ArrayList<>(albumsJsonArr.size());
        for (JsonElement albumJson : albumsJsonArr) {
            String albumName = albumJson.getAsJsonObject().get("name").getAsString();
            String href = albumJson.getAsJsonObject()
                    .getAsJsonObject("external_urls")
                    .get("spotify")
                    .getAsString();
            Album album = new Album(albumName, href);
            JsonArray artistsJson = albumJson.getAsJsonObject().getAsJsonArray("artists");
            for (JsonElement artistJson : artistsJson) {
                String artistName = artistJson.getAsJsonObject().get("name").getAsString();
                album.getArtists().add(artistName);
            }
            newReleases.add(album);
        }
        return newReleases;
    }

    @Override
    public List<String> getCategories() throws IOException, InterruptedException {
        JsonElement jsonElement = makeRequest(getApiServerPath() + "/v1/browse/categories");
        JsonArray categoriesJsonArr = jsonElement.getAsJsonObject()
                .getAsJsonObject("categories")
                .getAsJsonArray("items");
        List<String> categories = new ArrayList<>(categoriesJsonArr.size());
        for (JsonElement categoryJson : categoriesJsonArr) {
            String categoryName = categoryJson.getAsJsonObject().get("name").getAsString();
            categories.add(categoryName);
        }
        return categories;
    }

    @Override
    public List<Playlist> getPlaylistsByCategory(String category)
            throws IOException, InterruptedException, JsonHasErrorMessageException {
        JsonElement jsonElement = makeRequest(getApiServerPath() + "/v1/browse/categories");
        JsonArray categoriesJsonArr = jsonElement.getAsJsonObject()
                .getAsJsonObject("categories")
                .getAsJsonArray("items");
        String categoryId = "";
        boolean categoryFound = false;
        for (JsonElement categoryJson : categoriesJsonArr) {
            String categoryName = categoryJson.getAsJsonObject().get("name").getAsString();
            if (Objects.equals(category, categoryName)) {
                categoryId = categoryJson.getAsJsonObject().get("id").getAsString();
                categoryFound = true;
            }
        }
        if (!categoryFound) {
            return null;
        }

        jsonElement = makeRequest(getApiServerPath() + "/v1/browse/categories/" + categoryId + "/playlists");
        if (jsonElement.getAsJsonObject().has("error")) {
            String message = jsonElement.getAsJsonObject()
                    .getAsJsonObject("error")
                    .get("message")
                    .getAsString();
            throw new JsonHasErrorMessageException(message);
        }
        return getPlaylistsByJsonElem(jsonElement);
    }

    private List<Playlist> getPlaylistsByJsonElem(JsonElement jsonElement) {
        JsonArray playlistsJsonArr = jsonElement.getAsJsonObject()
                .getAsJsonObject("playlists")
                .getAsJsonArray("items");
        List<Playlist> playlists = new ArrayList<>(playlistsJsonArr.size());
        for (JsonElement playlistJson : playlistsJsonArr) {
            String playlistName = playlistJson.getAsJsonObject().get("name").getAsString();
            String playlistHref = playlistJson.getAsJsonObject()
                    .getAsJsonObject("external_urls")
                    .get("spotify")
                    .getAsString();
            playlists.add(new Playlist(playlistName, playlistHref));
        }
        return playlists;
    }

    private JsonElement makeRequest(String uriStr) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .header("Authorization", "Bearer " + accessToken)
                .uri(URI.create(uriStr))
                .GET()
                .build();
        HttpResponse<String> response;
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return JsonParser.parseString(response.body());
    }

}
