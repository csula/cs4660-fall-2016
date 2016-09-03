package csula.cs4660.graphs;

public class Edge {
    private Node from;
    private Node to;
    private int value;

    public Edge(Node from, Node to, int value) {
        this.from = from;
        this.to = to;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getFrom() {
        return from;
    }

    public void setFrom(Node from) {
        this.from = from;
    }

    public Node getTo() {
        return to;
    }

    public void setTo(Node to) {
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge)) return false;

        Edge edge = (Edge) o;

        if (getValue() != edge.getValue()) return false;
        if (getFrom() != null ? !getFrom().equals(edge.getFrom()) : edge.getFrom() != null)
            return false;
        return !(getTo() != null ? !getTo().equals(edge.getTo()) : edge.getTo() != null);

    }

    @Override
    public String toString() {
        return "Edge{" +
            "from=" + from +
            ", to=" + to +
            ", value=" + value +
            '}';
    }

    @Override
    public int hashCode() {
        int result = getFrom() != null ? getFrom().hashCode() : 0;
        result = 31 * result + (getTo() != null ? getTo().hashCode() : 0);
        result = 31 * result + getValue();
        return result;
    }
}
