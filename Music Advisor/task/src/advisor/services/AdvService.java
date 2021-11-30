package advisor.services;

import advisor.entities.Album;
import advisor.entities.Playlist;
import advisor.entities.PlaylistCategory;
import java.util.List;

public interface AdvService {

    List<Playlist> getFeaturedPlaylists();

    List<Album> getNewReleases();

    List<PlaylistCategory> getCategories();

    List<Playlist> getPlaylistsByCategory(PlaylistCategory category);
}
