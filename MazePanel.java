import java.awt.*;
import javax.swing.*;

public class MazePanel extends JPanel {

    private MazeButton[][] buttons;

    public MazePanel(Location[][] loc) {
	int size = loc.length;

	this.setLayout(new GridLayout(0, size));
	this.setPreferredSize(new Dimension(560, 560));

	buttons = new MazeButton[size][size];
	for (int i=0; i<size; i++) {
	    for (int j=0; j<size; j++) {
		buttons[i][j] = loc[i][j].getButton();
		this.add(buttons[i][j]);
	    }
	}
    }
    
}
