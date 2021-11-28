package advisor.services;

public interface AuthorizationService {

    boolean isAuthorized();

    String getAuthorizationLink();
}
