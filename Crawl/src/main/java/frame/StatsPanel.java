package frame;

import actor.Player;

/**
 * Created by mzwart on 24-11-2016.
 */
public class StatsPanel {

	private Player player;

	private String name;
	private int level;
	private int health;
	private int maxHealth;
	private int strength;
	private int extraStrength;
	private int accuracy;
	private int extraAccuracy;
	private int agility;
	private int extraAgility;
	private int powerScore;
	private int damage;
	private int protection;
	private int experience;
	private int coins;
	private static final int[] expArray = {0, 50, 60, 75, 90, 110, 140, 170, 200, 240, 285, 330, 385, 450, 510, 580, 660, 750, 850};


	public StatsPanel(Player player){
		this.player = player;
		this.name = player.getName();
	}

	public String update(){
		this.level = player.getLevel();
		this.health = player.getHealth();
		this.maxHealth = player.getMaxHealth();
		this.strength = player.getStrength();
		this.accuracy = player.getAccuracy();
		this.agility = player.getAgility();
		this.powerScore = player.calculateScore();
		this.experience = player.getExperience();
		this.coins = player.getCoins();
		getExtraStats();
		return setTopLeftPane();
	}
	/**
	 * Strength: Cuirass, mace, axe, spear
	 * Agility: Boots, sword, spear
	 * Accuracy: Gloves, mace, sword
	 */
	public void getExtraStats(){
		this.protection = player.getProtection();
		this.extraStrength = player.getCuirass().getStrength() + player.getMain().getStrength();
		this.extraAccuracy = player.getGloves().getAccuracy() + player.getMain().getAccuracy();
		this.extraAgility = player.getBoots().getAgility() + player.getMain().getAgility();
		this.damage = player.getDamage();
	}

	public String setTopLeftPane(){
		String leftTop;
		leftTop = "Name: " + name
			+ "\nLevel: " + level + "(" + experience + " / " + expArray[level] + ")"
			+ "\nHealth: " + health + " / " + maxHealth
			+ "\nCoins: " + coins + "\n\n"
			+ "\nProtection: " + protection
			+ "\nDamage: " + (0 + damage) + " - " + (9 + damage)
			+ "\nStrength: " + strength + "(" + extraStrength + ")"
			+ "\nAccuracy: " + accuracy + "(" + extraAccuracy + ")"
			+ "\nAgility: " + agility + "(" + extraAgility + ")"
			+ "\nPower score: " + powerScore;
		return leftTop;
	}

	/*public String checkArmorBay(List<Armor> armorList){
		String armor = "";
		if(armorList.isEmpty()){
			return armor;
		}else{
			for(int i = 0 ; i < armorList.size() ; i++) {
				armor += "a" + (i+1) + " ";
				armor += "Armor: " + armorList.get(i).getHullHealth() + " - Mis/Las def: "
					+ armorList.get(i).getMissileDefence() + "/" + armorList.get(i).getLaserDefence() + "\n";
			}
			armor += "\n";
		}
		return armor;
	}

	public String checkMissileBay(List<Missile> missileList){
		String missiles = "";
		if(missileList.isEmpty()){
			return missiles;
		}else{
			for(int i = 0 ; i < missileList.size() ; i++) {
				missiles += "m" + (i+1) + " ";
				missiles += "Missile damage: " + missileList.get(i).getDamage() + " ("
					+ missileList.get(i).getAmount() + ")\n";
			}
			missiles += "\n";
		}
		return missiles;
	}

	public String checkLaserBay(List<Laser> laserList){
		String lasers = "";
		if(laserList.isEmpty()){
			return lasers;
		}else{
			for(int i = 0 ; i < laserList.size() ; i++) {
				lasers += "l" + (i+1) + " ";
				lasers += "Laser damage: " + laserList.get(i).getDamage() + " ("
					+ laserList.get(i).getEnergyCost() + " p/t)\n";
			}
			lasers += "\n";
		}
		return lasers;
	}

	public String checkGeneratorBay(List<Generator> generatorList){
		String generators = "";
		if(generatorList.isEmpty()){
			return generators;
		}else{
			for(int i = 0 ; i < generatorList.size() ; i++) {
				generators += "g" + (i+1) + " ";
				generators += "Generator energy p/t: " + generatorList.get(i).getEnergyPerTurn() + "\n";
			}
			generators += "\n";
		}
		return generators;
	}*/
}
