package actor;

/**
 * Created by mzwart on 2-12-2016.
 */
public class Actor {

	protected String name;
	protected int level = 1;
	protected int health = 1000;
	protected int maxHealth = 1000;
	protected int strength = 1;
	protected int accuracy = 1;
	protected int agility = 1;
	protected int protection;
	protected int damage;
	protected int powerScore;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
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

	public int getPowerScore() {
		return powerScore;
	}

	public void setPowerScore(int powerScore) {
		this.powerScore = powerScore;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public int getProtection() {
		return protection;
	}

	public void setProtection(int protection) {
		this.protection = protection;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public void changeHealth(int change){
		this.health += change;
		if(this.health > this.maxHealth) this.health = this.maxHealth;
	}

	public int calculateScore(){
		int score = this.accuracy + this.agility + this.strength + (this.maxHealth/1000) + this.level;
		this.powerScore = score;
		return powerScore;
	}
}
