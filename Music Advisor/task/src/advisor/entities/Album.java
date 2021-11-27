package advisor.entities;

public class Album extends Entity {
    private String name;
    private String artist;

    public Album(String name, String artist) {
        super(name);
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " [" + artist + "]";
    }
}
