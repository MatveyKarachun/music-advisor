package advisor.services;

import advisor.entities.Album;
import advisor.entities.Playlist;

import java.io.IOException;
import java.util.List;

public interface AdvService  {

    List<Playlist> getFeaturedPlaylists() throws IOException, InterruptedException;

    List<Album> getNewReleases() throws IOException, InterruptedException;

    List<String> getCategories() throws IOException, InterruptedException;

    List<Playlist> getPlaylistsByCategory(String playlistsCategory) throws IOException, InterruptedException;
}
