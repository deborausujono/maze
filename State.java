import java.util.Vector;

public class State {

    private Location loc;
    private Information info;
    private RetraceInformation retraceInfo;

    public State(Location l, int v, boolean[] a, Vector<Location> t) {
	loc = l;
	info = new Information(v, a, t);
	retraceInfo = new RetraceInformation();
    }

    public int getCurrentVal() {
	return info.currentVal;
    }

    public State getFromState() {
	return retraceInfo.fromState;
    }

    public Location getLoc() {
	return loc;
    }

    public Vector<Location> getTargetLocs() {
	return info.targetLocs;
    }

    public Location getToLoc() {
	return retraceInfo.toLoc;
    }

    public void setFromState(State s) {
	retraceInfo.fromState = s;
    }
    
    public void setToLoc(Location l) {
	retraceInfo.toLoc = l;
    }
    
    public void setEnabledTargetLocs(boolean b) {
	for (Location l : info.targetLocs)
	    l.setEnabled(b);
    }

    public void addToQdStates() {
	loc.addToQdStates(this);
    }

    public boolean isInQdStates() {
	return loc.isInQdStates(this);
    }

    public boolean equals(State s) {
	return loc.equals(s.loc) && info.equals(s.info);
    }

}