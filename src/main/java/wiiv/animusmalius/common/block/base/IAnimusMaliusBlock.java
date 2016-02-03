package wiiv.animusmalius.common.block.base;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import wiiv.animusmalius.common.item.base.IVariantHolder;

public interface IAnimusMaliusBlock extends IVariantHolder {

	public String getBareName();
	
	public EnumRarity getBlockRarity(ItemStack stack);
	
}