import java.util.Vector;
import java.util.Scanner;

import java.awt.Color;

public class IntermedLocation extends Location {
  
    private Transition trans;
    private Vector<State> qdStates = new Vector<State>();
    private MazeButton button;

    public IntermedLocation(Scanner sc, int i, int j, TheGame g, String maze) {
	super(i, j);

	if (maze.equals("maze1")) {
	    trans = new Transition1(sc, this);
	    button = new MazeButton12(Color.green, trans.getVal());
	}
	else if (maze.equals("maze2")) {
	    trans = new Transition2(sc, this);
	    button = new MazeButton12(Color.green, trans.getVal());
	}
	else if (maze.equals("maze3")) {
	    trans = new Transition3(sc, this);
	    button = new 
		MazeButton3(Color.green, trans.getVal(), trans.getArrows());
	}
	else if (maze.equals("maze4")) {
	    trans = new Transition4(sc, this);
	    button = new 
		MazeButton4(Color.green, trans.getVal(), trans.getArrows());
	}

	GameHandler hand = new GameHandler(this, g);
	button.addActionListener(hand);
    }

    public MazeButton getButton() {
	return button;
    }

    public int getVal() {
	return trans.getVal();
    }

    public void setEnabled(boolean b) {
	button.setEnabled(b);
    }

    public State doTrans(State s, TheGame g) {
	return trans.doTrans(s, g);
    }

    public void addToQdStates(State s) {
	qdStates.add(s);
    }

    public boolean isInQdStates(State s1) {
	for (State s2 : qdStates) {
	    if (s1.equals(s2))
		return true;
	}
	return false;
    }
  
}