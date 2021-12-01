package advisor.services;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;

public class AuthorizationServiceImpl implements AuthorizationService {

    private static final String clientId = "1afffc1b2eb4435cb75fca994ef77267";
    private static final String redirectURI = "http://localhost:8080";
    private static String authorizationCode = "";

    private static String getAuthorizationLink() {
        return ServicesParams.getSpotifyServerPath() + "/authorize?"
                + "client_id=" + clientId + "&"
                + "redirect_uri=" + redirectURI + "&"
                + "response_type=code";
    }

    private static void printAuthorizationLink() {
        System.out.println(getAuthorizationLink());
    }

    public boolean startAuthorization() {
        HttpServer server = null;

        try {
            server = HttpServer.create();
        } catch (IOException e) {
            System.out.println("Failed to create HTTP server");
            e.printStackTrace();
            return false;
        }
        try {
            server.bind(new InetSocketAddress(ServicesParams.PORT), 0);
        } catch (IOException e) {
            System.out.println("Failed to bind HTTP server to port " + ServicesParams.PORT);
            e.printStackTrace();
            return false;
        }

        server.createContext("/",
                httpExchange -> {
                    String query = httpExchange.getRequestURI().getQuery();
                    if (query == null) {
                        query = "";
                    }
                    String[] paramAndValue = query.split("=");

                    String responseString;
                    if (Objects.equals(paramAndValue[0], "code")) {
                        responseString = "Got the code. Return back to your program.";
                        authorizationCode = paramAndValue[1];
                    } else {
                        responseString = "Authorization code not found. Try again.";
                    }
                    httpExchange.sendResponseHeaders(200, responseString.length());
                    httpExchange.getResponseBody().write(responseString.getBytes());
                    httpExchange.getResponseBody().close();
                }
        );

        server.start();
        System.out.println("use this link to request the access code:");
        printAuthorizationLink();
        System.out.println("waiting for code...");
        while (Objects.equals(authorizationCode, "")) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted during waiting for access code");
                server.stop(1);
                e.printStackTrace();
                return false;
            }
        }
        server.stop(1);
        System.out.println("code received");
        System.out.println("making http request for access_token...");

        HttpClient client = HttpClient.newBuilder().build();

        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .uri(URI.create(ServicesParams.getSpotifyServerPath() + "/api/token"))
                .POST(HttpRequest.BodyPublishers.ofString("grant_type=authorization_code"
                        + "&code=" + authorizationCode
                        + "&redirect_uri=" + redirectURI
                        + "&client_id=" + clientId
                        + "&client_secret=" + "da38af69a8fe466dab208ea86af9e876"
                    ))
                .build();

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            System.out.println("Something gone wrong during sending authorization_code");
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted during sending access code");
            e.printStackTrace();
            return false;
        }

        System.out.println("response:");
        System.out.println(response.body());
        if (response.statusCode() == 200) {
            System.out.println("---SUCCESS---");
        }
        return response.statusCode() == 200;
    }
}
