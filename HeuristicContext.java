public class HeuristicContext <E>{
    private HeuristicStrategy<E> strategy;

    //set the mutators
    public void setHeuristicStrategy(HeuristicStrategy<E> strategy) {
        this.strategy = strategy;
    }

    public int calculateHeuristic(Job<E> j, State<E> s) {
        return strategy.findHeuristic(j, s);
    }
}
