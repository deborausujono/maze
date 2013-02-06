import java.awt.Color;
import java.awt.Graphics;

import java.lang.Math;

public class MazeButton3 extends MazeButton {
	
    private Color bgCol;
    private Color arrowsCol;
    private Color dotCol = new Color(75, 75, 75, 0);
    private boolean[] arrows;
	
    public MazeButton3(Color bgC, int v, boolean[] a) {
	bgCol = bgC;
	arrows = a;

	if (v == -1) arrowsCol = Color.yellow;
	else if (v == 0) arrowsCol = Color.black;
	else if (v == 1) arrowsCol = Color.red;

	this.setEnabled(false);
	this.setBackground(bgCol);
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);

	if (arrows != null) {
	    //Draw arrows on the square
	    g.setColor(arrowsCol);
	    
	    int origin = 35;
	    double[] angles = { 0, Math.PI/4, Math.PI/2, 3*Math.PI/4,
				Math.PI, 5*Math.PI/4, 3*Math.PI/2, 7*Math.PI/4 };
	    
	    int[] xPts = { 35, 45, 40, 40, 30, 30, 25 };
	    int[] yPts = { 5, 15, 15, 40, 40, 15, 15 };
		
	    for (int i=0; i<arrows.length; i++) {
		if (arrows[i]) {
		    //System.out.println("Drawing " + i);
		    int[] newXPts = new int[xPts.length];
		    int[] newYPts = new int[yPts.length];
		    
		    for (int j=0; j<xPts.length; j++) {
			newXPts[j] = (int)(Math.cos(angles[i])*(xPts[j]-origin)
					   - Math.sin(angles[i])*
					   (yPts[j]-origin) + origin);
			newYPts[j] = (int)(Math.sin(angles[i])*(xPts[j]-origin)
					   + Math.cos(angles[i])*
					   (yPts[j]-origin) + origin);
		    }
		    
		    g.fillPolygon(newXPts, newYPts, xPts.length);
		}
	    }
	}

	else {
	    //Draw bull's eye on goal square
	    g.setColor(Color.blue);
	    g.fillOval(10, 10, 50, 50);

	    g.setColor(Color.red);
	    g.fillOval(20, 20, 30, 30);

	    g.setColor(Color.blue);
	    g.fillOval(30, 30, 10, 10);
	}

	//Draw a dot
	g.setColor(dotCol);
	g.fillOval(5, 5, 15, 15);
    }

    public void bump(int alpha) {
	dotCol = new Color(75, 75, 75, alpha);
	repaint();
    }

    public void showDot() {
	dotCol = new Color(75, 75, 75, 255);
	repaint();
    }
    
}
