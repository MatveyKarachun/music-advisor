package advisor.services;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;

public class AuthorizationServiceImpl extends AbstractService implements AuthorizationService {

    private static final String clientId = "1afffc1b2eb4435cb75fca994ef77267";
    private static final String redirectURI = "http://localhost:8080";
    private String authorizationCode = "";

    private static String getAuthorizationLink() {
        return AbstractService.getAuthorizationServerPath() + "/authorize?"
                + "client_id=" + clientId + "&"
                + "redirect_uri=" + redirectURI + "&"
                + "response_type=code";
    }

    private static void printAuthorizationLink() {
        System.out.println(getAuthorizationLink());
    }

    public String startAuthorization() {
        HttpServer server;

        try {
            server = HttpServer.create();
        } catch (IOException e) {
            System.out.println("Failed to create HTTP server");
            e.printStackTrace();
            return null;
        }
        try {
            server.bind(new InetSocketAddress(AbstractService.PORT), 0);
        } catch (IOException e) {
            System.out.println("Failed to bind HTTP server to port " + AbstractService.PORT);
            e.printStackTrace();
            return null;
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
                return null;
            }
        }
        server.stop(1);
        System.out.println("code received");
        System.out.println("making http request for access_token...");

        HttpClient client = HttpClient.newBuilder().build();

        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .uri(URI.create(AbstractService.getAuthorizationServerPath() + "/api/token"))
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
        } catch (IOException | InterruptedException e) {
            if (e.getClass().getSimpleName().equals("IOException")) {
                System.out.println("Something gone wrong during sending authorization_code");
            } else {
                System.out.println("Thread was interrupted during sending access code");
            }
            e.printStackTrace();
            return null;
        }

        System.out.println("response:");
        System.out.println(response.body());
        String accessToken = null;
        if (response.statusCode() == 200) {
            System.out.println("---SUCCESS---");
            JsonObject jo = JsonParser.parseString(response.body()).getAsJsonObject();
            accessToken = jo.get("access_token").getAsString();
        }
        return accessToken;
    }

}
