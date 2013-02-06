import java.util.Vector;

public class Information {

    int currentVal;
    boolean[] currentArrows;
    Vector<Location> targetLocs;

    public Information(int v, boolean[] a, Vector<Location> t) {
	currentVal = v;
	currentArrows = a;
	targetLocs = t;
    }

    public boolean equals(Information i) {
	if (currentArrows != null) {

	    boolean equalArrows = true;
	    for (int j=0; j<4; j++) {
		if (currentArrows[j] != i.currentArrows[j]) 
		    return false;
	    }
	    return (currentVal == i.currentVal) && equalArrows;

	}

	else return currentVal == i.currentVal;
    }
    
}