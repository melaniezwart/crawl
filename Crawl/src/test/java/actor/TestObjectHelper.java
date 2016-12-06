package actor;

import java.util.Random;

/**
 * Created by mzwart on 2-12-2016.
 */
public class TestObjectHelper {

	Random rng = new Random();

	public Player getPlayer(){
		Player player = new Player("Brick");
		player.setCoins(rng.nextInt(100));
		player.setMaxHealth(1000);
		player.setHealth(rng.nextInt(1000));
		player.setAgility(rng.nextInt(20));
		player.setStrength(rng.nextInt(20));
		player.setAccuracy(rng.nextInt(20));
		return player;
	}
}
