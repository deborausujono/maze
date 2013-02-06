import java.util.Vector;

public class SolverQ {
    
    private Vector<State> theQ;
    
    public SolverQ() {
	theQ = new Vector<State>();
    }
    
    public void add(State s){
	theQ.add(s);
    }
    
    public State remove() {
	return theQ.remove(0);
    }
    
}
