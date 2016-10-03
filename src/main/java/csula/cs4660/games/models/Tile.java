package csula.cs4660.games.models;

/**
 * A tile class to represent 2d tile
 */
public class Tile {
    private final int x;
    private final int y;
    private final String type;

    public Tile(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tile)) return false;

        Tile tile = (Tile) o;

        if (getX() != tile.getX()) return false;
        if (getY() != tile.getY()) return false;
        return getType() != null ? getType().equals(tile.getType()) : tile.getType() == null;

    }

    @Override
    public int hashCode() {
        int result = getX();
        result = 31 * result + getY();
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        return result;
    }
}
