import java.util.Vector;
import java.util.Scanner;

public class Transition2 implements Transition {

    private int val;
    private Location loc;

    public Transition2(Scanner sc, Location l) {
	val = sc.nextInt();
	loc = l;
    }

    public State doTrans(State oldState, TheGame g) {
	Vector<Location> targetLocs = new Vector<Location>();
	Location[][] locs = g.getLocations();
	
	int size = locs.length;
	int i = loc.getRow(), j = loc.getCol();	
	
	int dRow, dCol;
	if (oldState != null) {
	    dRow = oldState.getLoc().getRow() - i;
	    dCol = oldState.getLoc().getCol() - j;
	}
	else {
	    dRow = 0;
	    dCol = 0;
	}

	boolean[] arrows = new boolean[4];
	
	if (i-val >= 0 && !(dRow < 0)) { //up
	    targetLocs.add(locs[i-val][j]);
	    arrows[0] = true;
	}
	if (j+val < size && !(dCol > 0)) { //right
	    targetLocs.add(locs[i][j+val]);
	    arrows[1] = true;
	}
	if ((i+val < size) && !(dRow > 0)) { //down
	    targetLocs.add(locs[i+val][j]);
	    arrows[2] = true;
	}
	if (j-val >= 0 && !(dCol < 0)) { //left
	    targetLocs.add(locs[i][j-val]);
	    arrows[3] = true;
	}

	//If targetLocs is empty and you can't move, you lose!
	if (targetLocs.isEmpty()) {
	    g.setWin(false);
	    return null;
	}

	return new State(loc, val, arrows, targetLocs);
    }

    public int getVal() {
	return val;
    }
    
    public boolean[] getArrows() {
	return null;
    }
    
}