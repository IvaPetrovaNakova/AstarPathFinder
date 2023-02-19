package NewProjectAfterRevue;

public class Node {

    public CityState state;
    public int pathCost;
    public Node parent;

    public Node(CityState stValue) {
        this.state = stValue;
        this.pathCost = 0;
        this.parent = null;
    }

    public String toString() {
        return this.state.city;
    }

    public void printBackTrace() {
        if (parent != null)
            parent.printBackTrace();
        System.out.println("\t" + this.state.city + "\t" + pathCost);
    }

    @Override
    public boolean equals(Object o){
        boolean retVal = false;
        if (o instanceof Node){
            Node ptr = (Node) o;
            retVal = ptr.state == this.state;
        }
        return retVal;
    }
}
