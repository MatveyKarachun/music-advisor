package advisor.services;

public class AuthorizationServiceMockImpl implements AuthorizationService {

    private static final String spotifyLink = "accounts.spotify.com";
    private static final String redirectURI = "http://localhost:8080&response_type=code";

    private static final String clientId = "1afffc1b2eb4435cb75fca994ef77267";

    private boolean authorized = false;


    private String getAuthorizationLink() {
        authorized = true;
        return "https://" + spotifyLink + "/authorize?"
                + "client_id=" + clientId + "&"
                + "redirect_uri=" + redirectURI;

    }

    @Override
    public boolean startAuthorization() {
        System.out.println(getAuthorizationLink());
        return true;
    }
}
