package advisor.entities;

public class Playlist extends Entity {

    public Playlist(String name, String href) {
        super(name, href);
    }

    @Override
    public String toString() {
        return getName() + "\n"
                + getHref();
    }
}
