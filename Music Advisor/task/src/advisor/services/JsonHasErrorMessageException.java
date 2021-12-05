package advisor.services;

public class JsonHasErrorMessageException extends Exception {

    JsonHasErrorMessageException(String message) {
        super(message);
    }
}
