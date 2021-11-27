package advisor.ui;

import advisor.entities.Album;
import advisor.entities.Playlist;
import advisor.entities.PlaylistCategory;
import advisor.service.AdvService;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    private static final String userInputStr = "> ";

    private static final String titleNewReleases = "---NEW RELEASES---";
    private static final String titleFeatured = "---FEATURED---";
    private static final String titleCategories = "---CATEGORIES---";

    private static final String messageGoodbye = "---GOODBYE!---";
    private static final String messageWrongCommand = "Wrong command!";

    private static final String commandNew = "new";
    private static final String commandFeatured = "featured";
    private static final String commandCategories = "categories";
    private static final String commandPlaylists = "playlists";
    private static final String commandExit = "exit";

    private AdvService advService;

    public ConsoleUI() {
        advService = new AdvService();
    }

    public void go() {
        Scanner scanner = new Scanner(System.in);

        boolean userWantsToExit = false;
        while (!userWantsToExit) {
            System.out.print(userInputStr);
            String[] commandAndArg = scanner.nextLine()
                    .trim()
                    .split("\\s+", 2);
            String command = "";
            String arg = "";
            if (commandAndArg.length >= 1) {
                command = commandAndArg[0];
            }
            if (commandAndArg.length >= 2) {
                arg = commandAndArg[1];
            }
            switch (command) {
                case commandNew:
                    printNewReleases();
                    break;
                case commandFeatured:
                    printFeatured();
                    break;
                case commandCategories:
                    printCategories();
                    break;
                case commandPlaylists:
                    printPlaylistsByCategory(arg);
                    break;
                case commandExit:
                    userWantsToExit = true;
                    System.out.println(messageGoodbye);
                    break;
                default:
                    System.out.println(messageWrongCommand);
                    break;
            }
        }
    }

    private static String getPlaylistsTitleWithCategory(String category) {
        return "---" + category.toUpperCase() + " PLAYLISTS---";
    }

    private void printNewReleases() {
        List<Album> releases = advService.getNewReleases();
        System.out.println(titleNewReleases);
        releases.forEach(System.out::println);
    }

    private void printFeatured() {
        List<Playlist> playlists = advService.getFeaturedPlaylists();
        System.out.println(titleFeatured);
        playlists.forEach(System.out::println);
    }

    private void printCategories() {
        List<PlaylistCategory> categories = advService.getCategories();
        System.out.println(titleCategories);
        categories.forEach(System.out::println);
    }

    private void printPlaylistsByCategory(String categoryName) {
        PlaylistCategory playlistCategory = new PlaylistCategory(categoryName);
        List<Playlist> playlists = advService.getPlaylistsByCategory(playlistCategory);
        System.out.println(getPlaylistsTitleWithCategory(categoryName));
        playlists.forEach(System.out::println);
    }
}
