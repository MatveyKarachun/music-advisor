package advisor.services;

import advisor.entities.Album;
import advisor.entities.Playlist;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class AdvServiceImpl extends AbstractService implements AdvService {

    private String accessToken = "";

    public AdvServiceImpl(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public List<Playlist> getFeaturedPlaylists() {
        return null;
    }

    public List<Album> getNewReleases() {
        HttpClient client = HttpClient.newBuilder().build();

        HttpRequest request = HttpRequest.newBuilder()
                .header("Authorization", "Bearer " + accessToken)
                .uri(URI.create(getApiServerPath() + "/v1/browse/new-releases"))
                .GET()
                .build();
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            System.out.println("Something gone wrong during request");
            e.printStackTrace();
            return null;
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted during request");
            e.printStackTrace();
            return null;
        }

        System.out.println(response.body());
        return null;
    }

    @Override
    public List<String> getCategories() {
        return null;
    }

    @Override
    public List<Playlist> getPlaylistsByCategory(String category) {
        return null;
    }


}
