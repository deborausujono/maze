import java.util.Vector;
import java.util.Scanner;

public class Transition3 implements Transition {

    private int val;
    private boolean[] arrows = new boolean[8];
    private Location loc;

    public Transition3(Scanner sc, Location l) {
	val = sc.nextInt();
  
	for (int i=0; i<3; i++) {
	    int index = sc.nextInt();
	    if (index != -1) arrows[index] = true;
	}

	loc = l;
    }

    public State doTrans(State oldState, TheGame g) {
	Vector<Location> targetLocs = new Vector<Location>();
	Location[][] locs = g.getLocations();

	int oldVal;
	if (oldState != null ) oldVal = oldState.getCurrentVal();
	else oldVal = 1;

	int newVal = oldVal + val;
	//If new val is 0 and you can't move, you lose!
	if (newVal == 0) {
	    g.setWin(false);
	    return null;
	}

	int size= locs.length;
	int myRow = loc.getRow(), myCol = loc.getCol();
	
	if (arrows[0] && myRow-newVal>=0)
	    targetLocs.add(locs[myRow-newVal][myCol]);
	if (arrows[1] && myRow-newVal>=0 && myCol+newVal<size)
	    targetLocs.add(locs[myRow-newVal][myCol+newVal]);
	if (arrows[2] && myCol+newVal<size)
	    targetLocs.add(locs[myRow][myCol+newVal]);
	if (arrows[3] && myRow+newVal<size && myCol+newVal<size)
	    targetLocs.add(locs[myRow+newVal][myCol+newVal]);
	if (arrows[4] && myRow+newVal<size)
	    targetLocs.add(locs[myRow+newVal][myCol]);
	if (arrows[5] && myRow+newVal<size && myCol-newVal>=0)
	    targetLocs.add(locs[myRow+newVal][myCol-newVal]);
	if (arrows[6] && myCol-newVal>=0)
	    targetLocs.add(locs[myRow][myCol-newVal]);
	if (arrows[7] && myRow-newVal>=0 && myCol-newVal>=0)
	    targetLocs.add(locs[myRow-newVal][myCol-newVal]);
	
	//If targetLocs is empty and you can't move, you lose!
	if (targetLocs.isEmpty()) {
	    g.setWin(false);
	    return null;
	}

	return new State(loc, newVal, arrows, targetLocs);
    }

    public int getVal() {
	return val;
    }

    public boolean[] getArrows() {
	return arrows;
    }

}