package advisor.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class AdvServiceImpl extends AbstractService {

    private String accessToken = "";

    public AdvServiceImpl(String accessToken) {
        this.accessToken = accessToken;
    }

    public List getNewReleases() {
        HttpClient client = HttpClient.newBuilder().build();

        HttpRequest request = HttpRequest.newBuilder()
                .header("Authorization", "Bearer " + accessToken)
                .uri(URI.create(getApiServerPath() + "v1/browse/new-releases"))
                .GET()
                .build();
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            System.out.println("Something gone wrong during sending authorization_code");
            e.printStackTrace();
            return null;
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted during sending access code");
            e.printStackTrace();
            return null;
        }

        System.out.println(response.body());
        return null;
    }


}
