package items;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mzwart on 2-12-2016.
 * Abstract class to create weapons and put them in a list as used by the Lootroll class
 */
public abstract class ItemList {

	private static List<Armor> armorList = new ArrayList<>();
	private static List<Weapon> weaponList = new ArrayList<>();
	private static int lastId = 1;

	/**
	 * Head: none
	 * Boots: agility
	 * Cuirass: strength
	 * Gloves: accuracy
     */
	public static void fillArmorList(int level){
		armorList.clear();
		int id = lastId;
		for(int i = 0 ; i < 5 ; i++) {
			for(int a = 5 ; a > i ; a--) {
				armorList.add(new Armor(id++, level, 0, 0, 0, 1 + i + (level - 1),					 5 - i, "helmet"));
				armorList.add(new Armor(id++, level, 0, 0, 1 + i + (level - 1), 1 + i + (level - 1), 5 - i, "boots"));
				armorList.add(new Armor(id++, level, 0 + i + (level - 1), 0, 0, 1 + i + (level - 1), 5 - i, "cuirass"));
				armorList.add(new Armor(id++, level, 0, 1 + i + (level - 1), 0, 1 + i + (level - 1), 5 - i, "gloves"));
			}
		}
		lastId = id;
	}

	/**
	 * Sword: accuracy + agility
	 * Mace: strength + accuracy
	 * Axe: strength
	 * Spear: strength + agility
	 */
	public static void fillWeaponList(int level){
		weaponList.clear();
		int id = lastId;
		for(int i = 0 ; i < 5 ; i++) {
			for(int a = 5 ; a > i ; a--) {
				weaponList.add(new Weapon(id++, level, 0, 1 + i + (level - 1), 1 + i + (level - 1), 1 + i + (level - 1), 5 - i + (level - 1), "sword"));
				weaponList.add(new Weapon(id++, level, 1 + i + (level - 1), 1 + i + (level - 1), 0, 1 + i + (level - 1), 5 - i, "mace"));
				weaponList.add(new Weapon(id++, level, 1 + (i * 2) + (level - 1), 0, 0, 1 + i + (level - 1),			 5 - i, "axe"));
				weaponList.add(new Weapon(id++, level, 1 + i + (level - 1), 0, 1 + i + (level - 1), 1 + i + (level - 1), 5 - i, "spear"));
			}
		}
		lastId = id;
	}

	public static List<Weapon> getWeaponList() {
		return weaponList;
	}

	public static void setWeaponList(List<Weapon> weaponList) {
		ItemList.weaponList = weaponList;
	}

	public static List<Armor> getArmorList() {
		return armorList;
	}

	public static void setArmorList(List<Armor> armorList) {
		ItemList.armorList = armorList;
	}
}
