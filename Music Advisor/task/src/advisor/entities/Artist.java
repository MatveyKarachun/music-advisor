package advisor.entities;

public class Artist extends Entity {

    public Artist(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return getName();
    }
}
