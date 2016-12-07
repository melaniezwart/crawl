package actor;

import items.Armor;
import items.Weapon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mzwart on 2-12-2016.
 * Main class for the user/player, as derived from Actor. Handles the general leveling and that of the skills.
 *
 */
public class Player extends Actor {

	private static final int[] expArray = {0, 50, 60, 75, 90, 110, 140, 170, 200, 240, 285, 330, 385, 450, 510, 580, 660, 750, 850};
	private int coins;
	private int experience;

	private double swordSkill, maceSkill, axeSkill, spearSkill;

	//Player's item slots. Default armor equipped upon startup
	private Armor head = new Armor(0, 0, 0, 0, 0, 0, 0, "head");
	private Armor cuirass = new Armor(0, 0, 0, 0, 0, 0, 0, "cuirass");
	private Armor gloves = new Armor(0, 0, 0, 0, 0, 0, 0, "gloves");
	private Armor boots = new Armor(0, 0, 0, 0, 0, 0, 0, "boots");
	private Weapon main = new Weapon(0, 0, 0, 0, 0, 1, 0, "mace");

	//Player's inventory, divided into two parts
	private List<Armor> armorList = new ArrayList<>();
	private List<Weapon> weaponList = new ArrayList<>();

	public Player(String name){
		this.name = name;
		this.damage = 1;
	}

	public void levelUp(){
		while(this.experience > expArray[this.level]) {
			this.experience -= expArray[this.level];
			this.level++;
		}
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public void addExperience(int gainedExp){
		this.experience = this.experience + gainedExp;
	}

	public void changeCoins(int change){
		this.coins = this.coins + change;
	}

	public void changeMaxHealth(int change){
		this.maxHealth += change;
	}

	//Checks the armor type and then equips the armor to the proper slot
	public String equipArmor(Armor armor){
		String type = armor.getType();
		if(type.equals("head")){
			equipHead(armor);
		} else if(type.equals("cuirass")){
			equipCuirass(armor);
		} else if(type.equals("gloves")){
			equipGloves(armor);
		} else if(type.equals("boots")){
			equipBoots(armor);
		}
		return "You equipped your new armor.\n";
	}

	//Checks if a weapon is equipped and unequips the current one, then equips the new weapon.
	public String equipWeapon(Weapon weapon){
		if(this.main != null) unequip("main");
		this.weaponList.remove(weapon);
		this.main = weapon;
		this.damage += weapon.getDamage();
		this.accuracy += weapon.getAccuracy();
		this.agility += weapon.getAgility();
		this.strength += weapon.getStrength();
		return "You equipped your new weapon.\n";
	}

	//Unequips currently equipped armor pieces, then equips the new armor and alters the stats accordingly
	public void equipHead(Armor armor){
		if(this.head != null) unequip("head");
		this.armorList.remove(armor);
		this.protection += armor.getProtection();
	}

	public void equipCuirass(Armor armor){
		if(this.head != null) unequip("cuirass");
		this.armorList.remove(armor);
		this.protection += armor.getProtection();
		this.strength += armor.getStrength();
	}

	public void equipGloves(Armor armor){
		if(this.head != null) unequip("gloves");
		this.armorList.remove(armor);
		this.protection += armor.getProtection();
		this.accuracy += armor.getAccuracy();
	}

	public void equipBoots(Armor armor){
		if(this.head != null) unequip("boots");
		this.armorList.remove(armor);
		this.protection += armor.getProtection();
		this.agility += armor.getAgility();
	}

	public void unequip(String type){
		if(type.equals("head")){
			this.armorList.add(this.head);
			this.protection -= this.head.getProtection();
			this.head = null;
		} else if(type.equals("cuirass")){
			this.armorList.add(this.cuirass);
			this.protection -= this.getCuirass().getProtection();
			this.strength -= this.getCuirass().getStrength();
			this.cuirass = null;
		} else if(type.equals("gloves")){
			this.armorList.add(this.gloves);
			this.protection -= this.gloves.getProtection();
			this.accuracy -= this.gloves.getAccuracy();
			this.gloves = null;
		} else if(type.equals("boots")){
			this.armorList.add(this.boots);
			this.protection -= this.getBoots().getProtection();
			this.agility -= this.getBoots().getAgility();
			this.boots = null;
		} else if(type.equals("main")){
			this.weaponList.add(this.main);
			this.damage -= this.main.getDamage();
			this.strength -= this.main.getStrength();
			this.accuracy -= this.main.getAccuracy();
			this.agility -= this.main.getAgility();
			this.main = null;
		}
	}

	public Armor getHead() {
		return head;
	}

	public void setHead(Armor head) {
		this.head = head;
	}

	public Armor getCuirass() {
		return cuirass;
	}

	public void setCuirass(Armor cuirass) {
		this.cuirass = cuirass;
	}

	public Armor getGloves() {
		return gloves;
	}

	public void setGloves(Armor gloves) {
		this.gloves = gloves;
	}

	public Armor getBoots() {
		return boots;
	}

	public void setBoots(Armor boots) {
		this.boots = boots;
	}

	public Weapon getMain() {
		return main;
	}

	public void setMain(Weapon main) {
		this.main = main;
	}

	//Used when the player attacks an enemy and results in an increase in skill
	public void useWeapon(int damageDone){
		switch(this.main.getType()){
			case "sword":
				this.swordSkill += ((double)damageDone/100);
				this.accuracy += ((double)damageDone/150);
				this.agility += ((double)damageDone/150);
				break;
			case "mace":
				this.maceSkill += ((double)damageDone/100);
				this.strength += ((double)damageDone/150);
				this.accuracy += ((double)damageDone/150);
				break;
			case "axe":
				this.axeSkill += ((double)damageDone/100);
				this.strength += ((double)damageDone/75);
				break;
			case "spear":
				this.spearSkill += ((double)damageDone/100);
				this.strength += ((double)damageDone/150);
				this.agility += ((double)damageDone/150);
				break;
		}
	}

	//Used when the player is attacked and increases the max health
	public void damageHealth(int totalDamage){
		this.maxHealth += ((double)totalDamage/150);
	}

	public List<Armor> getArmorList() {
		return armorList;
	}

	public void setArmorList(List<Armor> armorList) {
		this.armorList = armorList;
	}

	public List<Weapon> getWeaponList() {
		return weaponList;
	}

	public void setWeaponList(List<Weapon> weaponList) {
		this.weaponList = weaponList;
	}
}
