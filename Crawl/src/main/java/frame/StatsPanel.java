package frame;

import actor.Player;
import items.Armor;
import items.Weapon;

import java.util.List;

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
			+ "\nPower score: " + powerScore + "\n\n\n"
			+ equippedToString(player.getHead(), player.getCuirass(), player.getGloves(), player.getBoots(), player.getMain())
			+ armorToString(player.getArmorList()) + weaponToString(player.getWeaponList());
		return leftTop;
	}

	public String equippedToString(Armor head, Armor cuirass, Armor gloves, Armor boots, Weapon weapon){
		String equipped = "";
		equipped = "Type - Protection - Str/Agi/Acc"
			+ "\nHead: " + head.getProtection() + " - " + head.getStrength() + "/" + head.getAgility() + "/" + head.getAccuracy()
			+ "\nCuirass: " + cuirass.getProtection() + " - " + cuirass.getStrength() + "/" + cuirass.getAgility() + "/" + cuirass.getAccuracy()
			+ "\nGloves: " + gloves.getProtection() + " - " + gloves.getStrength() + "/" + gloves.getAgility() + "/" + gloves.getAccuracy()
			+ "\nBoots: " + boots.getProtection() + " - " + boots.getStrength() + "/" + boots.getAgility() + "/" + boots.getAccuracy()
			+ "\nMain weapon: " + weapon.getDamage() + " - " + weapon.getStrength() + "/" + weapon.getAgility() + "/" + weapon.getAccuracy()
			+ "\n\n";
		return equipped;
	}

	public String armorToString(List<Armor> armorList){
		String armor = "";
		if(armorList.isEmpty()){
			return armor;
		}else{
			for(int i = 0 ; i < armorList.size() ; i++) {
				armor += "a" + (i+1) + " ";
				armor += "Armor: " + armorList.get(i).getType() + " - Prot: "
					+ armorList.get(i).getProtection() + " - Str/Agi/Acc: " + armorList.get(i).getStrength()
					+ "/" + armorList.get(i).getAgility() + "/" + armorList.get(i).getAccuracy()
					+ "\n";
			}
			armor += "\n";
		}
		return armor;
	}

	public String weaponToString(List<Weapon> weaponList){
		String weapons = "";
		if(weaponList.isEmpty()){
			return weapons;
		}else{
			for(int i = 0 ; i < weaponList.size() ; i++) {
				weapons += "m" + (i+1) + " ";
				weapons += "Weapon damage: " + weaponList.get(i).getDamage() + " - Str/Agi/Acc: "
					+ weaponList.get(i).getStrength() + "/" + weaponList.get(i).getAgility()
					+ "/" + weaponList.get(i).getAccuracy()
					+ "\n";
			}
			weapons += "\n";
		}
		return weapons;
	}
}
