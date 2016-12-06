package encounter;

import actor.Enemy;
import actor.Player;
import game.Game;

/**
 * Created by mzwart on 6-12-2016.
 * Handles the actions as used in an encounter.
 * Shows the stats of the enemy and gives you the option to fight or flee.
 */
public class Encounter {

	private Player player;
	private Enemy enemy;

	public Encounter(Player player){
		this.player = player;
		enemy = new Enemy();
		enemy.generateEnemy(player.getPowerScore());
	}

	public void startBattle(){
		new Battle(player, enemy);
	}

	public void endEncounter(){
		Game.setInEncounter(false);
	}
}
