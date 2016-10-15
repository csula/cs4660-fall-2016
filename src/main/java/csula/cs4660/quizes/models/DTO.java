package csula.cs4660.quizes.models;

/**
 * A simple DTO to wrap the Action object
 */
public class DTO {
    private String id;
    private String action;
    private Event event;

    public String getId() {
        return id;
    }

    public DTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getAction() {
        return action;
    }

    public DTO setAction(String action) {
        this.action = action;
        return this;
    }

    public Event getEvent() {
        return event;
    }

    public DTO setEvent(Event event) {
        this.event = event;
        return this;
    }

    @Override
    public String toString() {
        return "DTO{" +
            "id='" + id + '\'' +
            ", action='" + action + '\'' +
            ", event=" + event +
            '}';
    }
}
