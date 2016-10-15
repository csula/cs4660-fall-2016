package csula.cs4660.quizes.models;

/**
 * Event object shows what happens
 */
public class Event {
    private String name;
    private String description;
    private int effect;

    public String getName() {
        return name;
    }

    public Event setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Event setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getEffect() {
        return effect;
    }

    public Event setEffect(int effect) {
        this.effect = effect;
        return this;
    }

    @Override
    public String toString() {
        return "Event{" +
            "name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", effect=" + effect +
            '}';
    }
}
