package wiiv.animusmalius.common.core;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import wiiv.animusmalius.common.block.base.ModBlocks;
import wiiv.animusmalius.common.item.base.ModItems;
import wiiv.animusmalius.common.lib.LibMisc;
import wiiv.animusmalius.common.lib.LibResources;

public class AnimusMaliusCreativeTab extends CreativeTabs {

	public static AnimusMaliusCreativeTab INSTANCE = new AnimusMaliusCreativeTab();
	List list;

	public AnimusMaliusCreativeTab() {
		super(LibMisc.MOD_ID);
		//setBackgroundImageName(LibResources.GUI_CREATIVE);
	}

	@Override
	public ItemStack getIconItemStack() {
		return new ItemStack(ModItems.material);
	}

	@Override
	public Item getTabIconItem() {
		return getIconItemStack().getItem();
	}

	@Override
	public boolean hasSearchBar() {
		return true;
	}
	
	@Override
	public void displayAllReleventItems(List<ItemStack> p_78018_1_) {
		list = p_78018_1_;

		addItem(ModItems.material);

		//addBlock(ModBlocks.materialBlock);
	}

	private void addItem(Item item) {
		item.getSubItems(item, this, list);
	}

	private void addBlock(Block block) {
		addItem(Item.getItemFromBlock(block));
	}

	private void addStack(ItemStack stack) {
		list.add(stack);
	}
	
}