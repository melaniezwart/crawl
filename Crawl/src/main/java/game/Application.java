package game;

import frame.StartFrame;

/**
 * Created by mzwart on 2-12-2016.
 * Class that starts up the game, initializes the start frame and continues on to play the game
 */
public class Application {

	private static StartFrame sframe;

	public static void main(String[] args) {
		startFrame();
		new Game();
	}

	//Start the frame
	public static void startFrame(){
		sframe = new StartFrame();
		sframe.setVisible(true);
		sframe.getTextArea().append("What's your name?\n");
	}
}
