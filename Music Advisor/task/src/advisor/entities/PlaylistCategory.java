package advisor.entities;

import java.util.Objects;

public class PlaylistCategory extends Entity {

    public PlaylistCategory(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaylistCategory category = (PlaylistCategory) o;
        return Objects.equals(getName(), category.getName());
    }
}
