package advisor.entities;

public class Category extends Entity {

    public Category(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return getName();
    }
}
