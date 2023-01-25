/*
* @interface implementation of heuristic strategy
* */

public interface HeuristicStrategy<E> {
    public int findHeuristic(Job<E> j, State<E> s);
}
