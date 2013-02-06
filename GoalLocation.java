import java.awt.Color;

public class GoalLocation extends Location {

    private MazeButton button;

    public GoalLocation(int i, int j, TheGame g, String maze) {
	super(i, j);

	if (maze.equals("maze1") || maze.equals("maze2"))
	    button = new MazeButton12(Color.white, -2);
	else if (maze.equals("maze3"))
	    button = new MazeButton3(Color.white, -2, null);
	else if (maze.equals("maze4"))
	    button = new MazeButton4(Color.white, -2, null);

	GameHandler hand = new GameHandler(this, g);
	button.addActionListener(hand);
    }

    public MazeButton getButton() {
	return button;
    }

    public int getVal() {
	return -2;
    }

    public void setEnabled(boolean b) {
	button.setEnabled(b);
    }
  
    public State doTrans(State s, TheGame g) {
	g.setWin(true);
	return null;
    }

    public void addToQdStates(State s) {}
    public boolean isInQdStates(State s) { return false; }

}