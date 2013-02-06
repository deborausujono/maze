import java.util.Vector;
import java.util.Scanner;

public class Transition1 implements Transition {

    private int val;
    private Location loc;

    public Transition1(Scanner sc, Location l) {
	val = sc.nextInt();
	loc = l;
    }

    public State doTrans(State oldState, TheGame g) {
	Vector<Location> targetLocs = new Vector<Location>();
	Location[][] locs = g.getLocations();
	
	int size = locs.length;
	int i = loc.getRow(), j = loc.getCol();
	
	if (i+val < size)
	    targetLocs.add(locs[i+val][j]);
	if (i-val >= 0)
	    targetLocs.add(locs[i-val][j]);
	if (j+val < size)
	    targetLocs.add(locs[i][j+val]);
	if (j-val >= 0)
	    targetLocs.add(locs[i][j-val]);

	return new State(loc, val, null, targetLocs);
    }

    public int getVal() {
	return val;
    }
    
    public boolean[] getArrows() {
	return null;
    }
    
}