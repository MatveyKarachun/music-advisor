package advisor.services;

import advisor.entities.Album;
import advisor.entities.Playlist;
import java.util.List;

public interface AdvService {

    List<Playlist> getFeaturedPlaylists();

    List<Album> getNewReleases();

    List<String> getCategories();

    List<Playlist> getPlaylistsByCategory(String playlistsCategory);
}
