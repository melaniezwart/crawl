package items;

/**
 * Created by mzwart on 2-12-2016.
 * Class for the weapons a player can equip. Depending on the type of weapon, these items come with
 * extra stats to strength, agility or accuracy.
 */
public class Weapon extends Item{

	private int damage;

	public Weapon(int id, int level, int strength, int accuracy, int agility, int damage, int dropchance, String type){
		this.id = id;
		this.level = level;
		this.strength = strength;
		this.accuracy = accuracy;
		this.agility = agility;
		this.damage = damage;
		this.dropchance = dropchance;
		this.type = type;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
}
