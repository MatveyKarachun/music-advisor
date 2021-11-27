package advisor.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Album extends Entity {
    private List<Artist> artists;

    public Album(String name, List<Artist> artists) {
        super(name);
        this.artists = new ArrayList<>(artists);
    }

    @Override
    public String toString() {
        String result = getName() + " " + Arrays.toString(artists.toArray());
        return result;
    }
}
