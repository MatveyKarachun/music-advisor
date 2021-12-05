package advisor.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Album extends Entity {

    private final List<String> artists;

    public Album(String name, String href) {
        super(name, href);
        artists = new ArrayList<>();
    }

    public List<String> getArtists() {
        return artists;
    }

    @Override
    public String toString() {
        return getName() + "\n"
                + Arrays.toString(artists.toArray()) + "\n"
                + getHref() + "\n";
    }
}
