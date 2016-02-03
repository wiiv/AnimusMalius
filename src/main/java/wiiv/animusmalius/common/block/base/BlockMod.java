/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Psi Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Psi
 * 
 * Psi is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 * 
 * File Created @ [09/01/2016, 22:43:48 (GMT)]
 */
package wiiv.animusmalius.common.block.base;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wiiv.animusmalius.common.core.AnimusMaliusCreativeTab;
import wiiv.animusmalius.common.item.base.ItemBlockMod;

public class BlockMod extends Block implements IAnimusMaliusBlock {

	private final String[] variants;
	private final String bareName;
	
	public BlockMod(String name, Material materialIn, String... variants) {
		super(materialIn);
		
		if(variants.length == 0)
			variants = new String[] { name };
		
		bareName = name;
		this.variants = variants;
		
		setUnlocalizedName(name);
		setCreativeTab(AnimusMaliusCreativeTab.INSTANCE);
	}
	
	@Override
	public Block setUnlocalizedName(String name) {
		super.setUnlocalizedName(name);
		setRegistryName(name);
		GameRegistry.registerBlock(this, ItemBlockMod.class);
		return this;
	}
	
	@Override
	public int getRenderType() {
		return 3;
	}

	public String getBareName() {
		return bareName;
	}
	
	@Override
	public String[] getVariants() {
		return variants;
	}

	@Override
	public ItemMeshDefinition getCustomMeshDefinition() {
		return null;
	}

	@Override
	public EnumRarity getBlockRarity(ItemStack stack) {
		return EnumRarity.COMMON;
	}
	
}
