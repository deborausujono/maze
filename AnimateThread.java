public class AnimateThread extends Thread {

    MazeButton button;

    public AnimateThread(MazeButton b) {
	button = b;
	//System.out.println("In AnimateThread!");
    }

    public void run() {
	//System.out.println("Run starts");
	int alpha = 255;

	while (alpha >= 0) {
	    //System.out.println("Bumping...");
	    button.bump(alpha);
	    
	    try {
		sleep(1);
	    } 
	    catch (InterruptedException e) {
		e.printStackTrace();
	    }

	    alpha--;
	}

	//System.out.println("Run finishes");
    }
    
}
