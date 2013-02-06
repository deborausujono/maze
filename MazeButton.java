import javax.swing.JButton;

public abstract class MazeButton extends JButton {

    public abstract void bump(int alpha);
    public abstract void showDot();
    
}
