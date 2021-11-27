package advisor.entities;

public abstract class Entity {
    private String name;

    Entity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    };
}
