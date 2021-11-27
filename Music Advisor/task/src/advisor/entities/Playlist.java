package advisor.entities;

public class Playlist extends Entity {

    public Playlist(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return getName();
    }
}
