package csula.cs4660.quizes.models;

import java.util.Arrays;

/**
 * A data transfer model to represent the state
 */
public class State {
    private String id;
    private Location location;
    private State[] neighbors;

    public String getId() {
        return id;
    }

    public State setId(String id) {
        this.id = id;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public State setLocation(Location location) {
        this.location = location;
        return this;
    }

    public State[] getNeighbors() {
        return neighbors;
    }

    public State setNeighbors(State[] neighbors) {
        this.neighbors = neighbors;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State)) return false;

        State state = (State) o;

        return getId() != null ? getId().equals(state.getId()) : state.getId() == null;

    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "State{" +
            "id='" + id + '\'' +
            ", location=" + location +
            ", neighbors=" + Arrays.toString(neighbors) +
            '}';
    }

    public class Location {
        private String name;
        private String description;

        public String getName() {
            return name;
        }

        public Location setName(String name) {
            this.name = name;
            return this;
        }

        public String getDescription() {
            return description;
        }

        public Location setDescription(String description) {
            this.description = description;
            return this;
        }

        @Override
        public String toString() {
            return "Location{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
        }
    }
}
