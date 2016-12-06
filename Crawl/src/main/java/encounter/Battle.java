package encounter;

import actor.Enemy;
import actor.Player;
import game.Game;
import items.LootRoll;

import java.util.Random;

/**
 * Created by mzwart on 6-12-2016.
 * Class to perform the actual battle between the player and the enemy
 */
public class Battle {

	private Player player;
	private Enemy enemy;
	private Random rng = new Random();

	public Battle(Player player, Enemy enemy){
		this.player = player;
		this.enemy = enemy;
		battle();
	}

	//Main method for the battle. Loop continues until either party's health drops below 0.
	public void battle(){
		while(player.getHealth() > 0 && enemy.getHealth() > 0){
			attackEnemy();
			attackPlayer();
		}
		if(player.getHealth() < 0) lose();
		else if(enemy.getHealth() < 0) win();
		else if(enemy.getHealth() < 0 && player.getHealth() < 0) draw();
		else System.out.println("Something went wrong, investigate pl0x");
	}

	public void attackEnemy(){
		int totalDamage = damageCalc((double)player.getDamage(), enemy.getProtection());
		enemy.changeHealth(-totalDamage);
		player.useWeapon(totalDamage);
	}

	public void attackPlayer(){
		int totalDamage = damageCalc((double)enemy.getDamage(), player.getProtection());
		player.changeHealth(-totalDamage);
		player.damageHealth(totalDamage);
	}

	//Calculates the total damage done to the enemy or the player. Input is attacker damage and defender protection
	public int damageCalc(double damage, int protection){
		double maxProtection = (damage / 10) * 8; //max protection is 80% of the damage
		double minDamage = damage - maxProtection;
		double totalDamage = damage - protection;
		if(totalDamage < minDamage)
			totalDamage = minDamage;
		if(totalDamage < 1)
			totalDamage = 1;
		return (int)totalDamage;
	}

	public void win(){
		if(rng.nextInt(100) > 80) {
			new LootRoll();
		}
		Game.setInEncounter(false);
	}

	public void lose(){
		Game.setInEncounter(false);
	}

	public void draw(){
		Game.setInEncounter(false);
	}
}
