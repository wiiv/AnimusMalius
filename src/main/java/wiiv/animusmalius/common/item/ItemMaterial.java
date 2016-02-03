package wiiv.animusmalius.common.item;

import wiiv.animusmalius.common.item.base.ItemMod;
import wiiv.animusmalius.common.lib.LibItemNames;

public class ItemMaterial extends ItemMod {

	public static final String[] VARIANTS = {
			"salt"
	};
	
	public ItemMaterial() {
		super(LibItemNames.MATERIAL, VARIANTS);
	}
}