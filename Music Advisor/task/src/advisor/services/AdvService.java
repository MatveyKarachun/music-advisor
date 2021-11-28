package advisor.services;

import advisor.entities.Album;
import advisor.entities.Artist;
import advisor.entities.Playlist;
import advisor.entities.PlaylistCategory;

import java.util.ArrayList;
import java.util.List;

public class AdvService {

    public List<Playlist> getFeaturedPlaylists() {
        List<Playlist> featuredPlaylists = new ArrayList<>();
        featuredPlaylists.add(new Playlist("Mellow Morning"));
        featuredPlaylists.add(new Playlist("Wake Up and Smell the Coffee"));
        featuredPlaylists.add(new Playlist("Monday Motivation"));
        featuredPlaylists.add(new Playlist("Songs to Sing in the Shower"));
        return featuredPlaylists;
    }

    public List<Album> getNewReleases() {
        List<Album> releases = new ArrayList<>();
        List<Artist> lsd = List.of(new Artist("Sia")
                , new Artist("Diplo")
                , new Artist("Labrinth"));
        releases.add(new Album("Mountains", lsd));
        releases.add(new Album("Runaway", List.of(new Artist("Lil Peep"))));
        releases.add(new Album("The Greatest Show", List.of(new Artist("Panic! At The Disco"))));
        releases.add(new Album("All Out Life", List.of(new Artist("Slipknot"))));
        return releases;
    }


    public List<PlaylistCategory> getCategories() {
        List<PlaylistCategory> categories = new ArrayList<>();
        categories.add(new PlaylistCategory("Top Lists"));
        categories.add(new PlaylistCategory("Pop"));
        categories.add(new PlaylistCategory("Mood"));
        categories.add(new PlaylistCategory("Latin"));
        return categories;
    }

    public List<Playlist> getPlaylistsByCategory(PlaylistCategory category) {
        List<Playlist> playlists = new ArrayList<>();
        playlists.add(new Playlist("Walk Like A Badass"));
        playlists.add(new Playlist("Rage Beats "));
        playlists.add(new Playlist("Arab Mood Booster "));
        playlists.add(new Playlist("Sunday Stroll"));
        return playlists;
    }
}
