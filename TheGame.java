import java.util.Vector;

public class TheGame {

    MazeFrame frame;
    State activeState;
    boolean win;
	
    public TheGame(MazeFrame f) {
	frame = f;
    }

    public Location[][] getLocations() {
	return frame.getLocations();
    }

    public void setWin(boolean b) {
	win = b;
    }

    public void start(Location l) {
	cont(l);
    }
    
    public void cont(Location l) {
	Location[][] locations = frame.getLocations();
	//System.out.println(l);

	if (activeState != null) {
	    //System.out.println("activeState not null?!");
	    activeState.setEnabledTargetLocs(false);

	    int[] start = { activeState.getLoc().getRow(), 
			    activeState.getLoc().getCol() };
	    int[] finish = { l.getRow(), l.getCol() };
	    
	    animate(start, finish);
	}
	activeState = l.doTrans(activeState, this);
	if (activeState != null) {
	    activeState.setEnabledTargetLocs(true);
	    //System.out.println("Target locations enabled!");
	}
	else end();
    }

    public void end() {
	if (win) frame.setMessage("Game over. Congratulations, you win!");
	else frame.setMessage("Game over. Sorry, you lose!");
    }

    public void animate(int[] start, int[] finish) {
	int i = start[0], j = start[1];
	//System.out.println("Start: " + start[0] + start[1]);
	//System.out.println("Finish: " + finish[0] + finish[0]);
	Location[][] locations = getLocations();

	AnimateThread thread = null;

	while (!(i==finish[0] && j==finish[1])) {
	    //System.out.println(i + " " + j);
	    thread = new AnimateThread(locations[i][j].getButton());
	    thread.start();

	    if (start[0]-finish[0] < 0) i++;
	    else if (start[0]-finish[0] > 0) i--;

	    if (start[1]-finish[1] < 0) j++;
	    else if (start[1]-finish[1] > 0) j--;
	}

	locations[finish[0]][finish[1]].getButton().showDot();

	/*
	try { 
	    thread.wait();
	    thread.join(); 
	    SwingUtilities.invokeLater();
	}
	catch (InterruptedException e) { e.printStackTrace(); }
	*/
    }

    public void solve() {
	SolverQ q = new SolverQ();

	q.add(activeState);
	activeState.addToQdStates();

	State solverActiveSt;
	outerloop:
	while (true) {
	    //System.out.println("Solving...");
	    solverActiveSt = q.remove();

	    Vector<Location> targetLocs = solverActiveSt.getTargetLocs();
	    for (Location l : targetLocs) {
		State newState = l.doTrans(solverActiveSt, this);
		if (newState != null) {
		    if (!newState.isInQdStates()) {
			//System.out.println("Adding " + newState.getLoc());
			q.add(newState);
			newState.addToQdStates();
			newState.setFromState(solverActiveSt);
		    }
		}
		else {
		    if (win) {
			solverActiveSt.setToLoc(l);
			break outerloop;
		    }
		}
	    }
	}

	retrace(solverActiveSt);
    }

    private void retrace(State s) {
	State fromState = s.getFromState();

	if (fromState != null) {
	    fromState.setToLoc(s.getLoc());
	    System.out.print(fromState.getLoc().getRow());
	    System.out.println(" "+fromState.getLoc().getCol());
	    retrace(fromState);
	}
	
	cont(s.getToLoc());
    }

}
