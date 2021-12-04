package advisor.entities;

abstract class Entity {

    private final String name;
    private String href;

    Entity(String name) {
        this.name = name;
    }

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

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public abstract String toString();
}
