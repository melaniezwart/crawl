package items;

/**
 * Created by mzwart on 2-12-2016.
 * Class for the armor items a player can equip. Depending on the type the armor offers protection and
 * a possible boost to strength, accuracy and agility
 */
public class Armor extends Item{

	private int protection;

	public Armor(int id, int level, int strength, int accuracy, int agility, int protection, int dropchance, String type){
		this.id = id;
		this.level = level;
		this.strength = strength;
		this.accuracy = accuracy;
		this.agility = agility;
		this.protection = protection;
		this.dropchance = dropchance;
		this.type = type;
	}

	public int getProtection() {
		return protection;
	}

	public void setProtection(int protection) {
		this.protection = protection;
	}
}
