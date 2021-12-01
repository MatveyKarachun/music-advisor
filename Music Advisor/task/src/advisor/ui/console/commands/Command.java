package advisor.ui.console.commands;

import advisor.services.AdvService;

import java.util.Objects;

public interface Command {

    boolean execute(String... params);

    String getName();

    default boolean nameIs(String supposed) {
        return Objects.equals(supposed, getName());
    }
}
