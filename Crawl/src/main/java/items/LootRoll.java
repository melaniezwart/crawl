package items;

import java.util.Random;

/**
 * Created by mzwart on 2-12-2016.
 * Class used to get a random item from the lists created in the ItemList class
 */
public class LootRoll {

	Random rng = new Random();

	public LootRoll(){
		getItem();
	}

	public void getItem(){
		int index = ItemList.getArmorList().size() + ItemList.getWeaponList().size() - 2;
		int roll = rng.nextInt(index);
		if(roll > (ItemList.getArmorList().size() - 1)){
			ItemList.getWeaponList().get(roll - ItemList.getArmorList().size() - 1);
		} else
			ItemList.getArmorList().get(roll);
	}
}
