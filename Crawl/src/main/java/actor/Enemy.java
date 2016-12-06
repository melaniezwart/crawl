package actor;

import java.util.Random;

/**
 * Created by mzwart on 2-12-2016.
 * General class for enemies, as derived from the Actor class
 */
public class Enemy extends Actor{

	private String[] nameList = {"John", "Trump", "Bush", "Mr. Snugglepuff", "Ivan the Terrible", "Ivan the Mediocre", "Vlad"};

	//Generates a random enemy with stats depending on the total score of the player
	public void generateEnemy(int score){
		score = score / 5;
		Random rng = new Random();
		Enemy enemy = new Enemy();
		enemy.setName(nameList[rng.nextInt(nameList.length - 1)]);
		enemy.setHealth(rng.nextInt(score * 500));
		enemy.setStrength(rng.nextInt(score));
		enemy.setAccuracy(rng.nextInt(score));
		enemy.setAgility(rng.nextInt(score));
		enemy.setProtection(rng.nextInt(score));
		enemy.setDamage(rng.nextInt(score));
		enemy.setMaxHealth(enemy.getHealth());
	}
}
