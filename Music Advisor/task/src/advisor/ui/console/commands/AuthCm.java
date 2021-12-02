package advisor.ui.console.commands;

import advisor.services.AdvService;
import advisor.services.AuthorizationService;

public class AuthCm implements Command {

    private static final String name = "auth";

    private final AuthorizationService authorizationService;

    public AuthCm(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @Override
    public boolean execute(String... params) {
        authorizationService.startAuthorization();
        return true;
    }

    @Override
    public String getName() {
        return name;
    }
}
