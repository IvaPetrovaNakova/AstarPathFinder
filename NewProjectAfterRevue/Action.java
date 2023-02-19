package NewProjectAfterRevue;

public class Action {
    public CityState child;
    public int cost;

    public Action(CityState child, int c) {
        this.child = child;
        this.cost = c;
    }

    public String toString() {
        return (child.toString() + " " + cost);
    }
}
