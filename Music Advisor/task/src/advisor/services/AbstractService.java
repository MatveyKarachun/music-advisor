package advisor.services;

public abstract class AbstractService {

    private static String authorizationServerPath = "https://accounts.spotify.com";
    private static String apiServerPath = "https://api.spotify.com";
    private static boolean authorizationServerPathWasChanged = false;
    private static boolean apiServerPathWasChanged = false;

    static final int PORT = 8080;

    public static boolean setAuthorizationServerPath(String newPath) {
        if (!authorizationServerPathWasChanged) {
            authorizationServerPathWasChanged = true;
            authorizationServerPath = newPath;
            return true;
        } else {
            return false;
        }
    }

    static String getAuthorizationServerPath() {
        return authorizationServerPath;
    }

    public static boolean setApiServerPath(String newPath) {
        if (!apiServerPathWasChanged) {
            apiServerPathWasChanged = true;
            apiServerPath = newPath;
            return true;
        } else {
            return false;
        }
    }

    static String getApiServerPath() {
        return apiServerPath;
    }
}
