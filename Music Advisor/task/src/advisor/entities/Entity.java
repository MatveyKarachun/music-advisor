package advisor.entities;

public abstract class Entity {

    private String name;
    private String href;

    Entity(String name, String href) {
        this.name = name;
        this.href = href;
    }

    public String getName() {
        return name;
    }

    public String getHref() {
        return href;
    }

    @Override
    public abstract String toString();

}
