import java.awt.event.*;
import javax.swing.JButton;

public class SolverHandler implements ActionListener {

    private TheGame game;
    private JButton solver;

    public SolverHandler(TheGame g, JButton s) {
	game = g;
	solver = s;
    }
    
    public void actionPerformed(ActionEvent e) {
	solver.setEnabled(false);
	game.solve();
    }

}
