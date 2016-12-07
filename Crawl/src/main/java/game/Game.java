package game;

import actor.Player;
import encounter.Encounter;
import frame.ChanDown;
import frame.StatsPanel;

import java.util.Random;

/**
 * Created by mzwart on 2-12-2016.
 * Main class for the wider functions of the game.
 * Processes the actions and validates the input.
 */
public class Game {

	private static ChanDown frame;
	private static StatsPanel statsPanel;
	private static boolean inEncounter;
	private Random rng = new Random();

	private Encounter encounter;
	private static Player player;

	public Game(){

	}

	//Initialize the game and set up the frame. Also sets the player name.
	public static void init(String action){
		Game game = new Game();
		player = new Player(action);
		frame = new ChanDown(game);
		frame.getTextArea().append("Welcome, " + action + "\n");
		//frame.getTextArea().append(defaultMove);
		statsPanel = new StatsPanel(player);
		frame.getLeftTop().setText(statsPanel.setTopLeftPane());
		frame.getLeftTop().setText(statsPanel.update());
		frame.setVisible(true);
	}

	public void action(String action){
		if(validInput(action.toLowerCase())){
			if(inEncounter){
				switch(action.toLowerCase().substring(0, 1)){
					case "b":
						encounter.startBattle();
						break;
					case "f":
					case "r":
						if(fleeRoll()) endEncounter();
						break;
				}
			}
		}
		System.out.println(action + "currently has no function.");
		frame.getLeftTop().setText(statsPanel.update());
	}

	public static void updateStatsPanel(){
		statsPanel.update();
	}

	/**
	 * E = Explore
	 * In encounter:
	 * B = Battle
	 * F = Fight
	 * R = Run away
     */
	public boolean validInput(String input){
		String a = input.substring(0,1);
		if(a.equals("e")){
			return true;
		}
		if(inEncounter){
			if(a.equals("b") || a.equals("f") || a.equals("r"))
				return true;
		}
		frame.getTextArea().append("Invalid input, try again.\n");
		return false;
	}

	public void encounterRoll(){
		if(rng.nextInt(100) > 50){
			startEncounter();
		}
	}

	public void endEncounter(){
		inEncounter = false;
	}
	public void startEncounter(){
		inEncounter = true;
		encounter = new Encounter(player);
	}

	public boolean fleeRoll(){
		if(rng.nextInt(100) + player.getAgility() > 50){
			return true;
		} else return false;
	}

	public static boolean isInEncounter() {
		return inEncounter;
	}

	public static void setInEncounter(boolean inEncounter) {
		Game.inEncounter = inEncounter;
	}

	//E = Explore
}
