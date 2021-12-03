package advisor.ui.console.commands;

import advisor.services.AuthorizationService;

public class AuthCm implements Command {

    private static final String name = "auth";

    private final AuthorizationService authorizationService;

    private String accessToken = "";

    public AuthCm(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @Override
    public boolean execute(String... params) {
        accessToken = authorizationService.startAuthorization();
        return true;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
