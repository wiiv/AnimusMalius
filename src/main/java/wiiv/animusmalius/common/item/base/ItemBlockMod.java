package wiiv.animusmalius.common.item.base;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wiiv.animusmalius.common.block.base.IAnimusMaliusBlock;
import wiiv.animusmalius.common.lib.LibResources;

public class ItemBlockMod extends ItemBlock implements IVariantHolder {

	private IAnimusMaliusBlock animusMaliusBlock;
	
	public ItemBlockMod(Block block) {
		super(block);
		animusMaliusBlock = (IAnimusMaliusBlock) block;
		
		ItemMod.variantHolders.add(this);
		if(getVariants().length > 1)
			setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int damage) {
		return damage;
	}
	
	@Override
	public ItemBlock setUnlocalizedName(String par1Str) {
		GameRegistry.registerItem(this, par1Str);
		return super.setUnlocalizedName(par1Str);
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		int dmg = par1ItemStack.getItemDamage();
		String[] variants = getVariants();
		
		String name;
		if(dmg >= variants.length)
			name = animusMaliusBlock.getBareName();
		else name = variants[dmg];
		
		return "tile." + LibResources.PREFIX_MOD + name;
	}
	 
	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
		String[] variants = getVariants();
		for(int i = 0; i < variants.length; i++)
			subItems.add(new ItemStack(itemIn, 1, i));
	}
	
	@Override
	public String[] getVariants() {
		return animusMaliusBlock.getVariants();
	}

	@Override
	public ItemMeshDefinition getCustomMeshDefinition() {
		return animusMaliusBlock.getCustomMeshDefinition();
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return animusMaliusBlock.getBlockRarity(stack);
	}

}
