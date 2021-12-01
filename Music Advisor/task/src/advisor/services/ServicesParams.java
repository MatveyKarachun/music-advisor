package advisor.services;

public final class ServicesParams {

    private static String spotifyServerPath = "https://accounts.spotify.com";

    public static final int PORT = 8080;

    private static boolean spotifyServerPathWasChanged = false;

    public static boolean setSpotifyServerPath(String newPath) {
        if (!spotifyServerPathWasChanged) {
            spotifyServerPathWasChanged = true;
            spotifyServerPath = newPath;
            return true;
        } else {
            return false;
        }
    }

    public static String getSpotifyServerPath() {
        return spotifyServerPath;
    }
}
