package advisor.controller;

enum ConsoleCommand {
    COMM_FEATURED("featured"),
    COMM_NEW("new"),
    COMM_CATEGORIES("categories"),
    COMM_PLAYLISTS("playlists");

    private String commStr;

    ConsoleCommand(String commStr) {
        this.commStr = commStr;
    }

    public String getCommStr() {
        return commStr;
    }
}
