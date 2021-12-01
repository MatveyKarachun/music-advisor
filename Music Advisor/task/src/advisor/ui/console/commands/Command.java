package advisor.ui.console.commands;

import advisor.services.AdvService;

import java.util.Objects;

interface Command {

    void execute(AdvService advService, String... params);

    String getName();

    default boolean nameIs(String supposed) {
        return Objects.equals(supposed, getName());
    }
}
