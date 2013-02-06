import java.awt.event.*;

public class GameHandler implements ActionListener {
      
    Location loc;
    TheGame game;

    public GameHandler(Location l, TheGame g) {
	loc = l;
	game = g;
    }
    
    public void actionPerformed(ActionEvent e) {
	game.cont(loc);
    }

}
