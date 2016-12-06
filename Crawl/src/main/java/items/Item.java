package items;

/**
 * Created by mzwart on 2-12-2016.
 * Umbrella class for weapons and armor.
 */
public class Item {

	protected int level;
	protected int id;
	protected int strength;
	protected int accuracy;
	protected int agility;
	protected String type;
	protected int dropchance;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDropchance() {
		return dropchance;
	}

	public void setDropchance(int dropchance) {
		this.dropchance = dropchance;
	}
}
