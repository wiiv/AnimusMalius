package wiiv.animusmalius.client.core.handler;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameData;
import wiiv.animusmalius.common.block.base.IVariantEnumHolder;
import wiiv.animusmalius.common.item.base.IVariantHolder;
import wiiv.animusmalius.common.item.base.ItemMod;
import wiiv.animusmalius.common.lib.LibResources;

public class ModelHandler {

	public static HashMap<String, ModelResourceLocation> resourceLocations = new HashMap();
	
	public static void init() {
		for(IVariantHolder holder : ItemMod.variantHolders)
			registerModels(holder);
	}

	public static void registerModels(IVariantHolder holder) {
		ItemMeshDefinition def = holder.getCustomMeshDefinition();
		if(def != null)
			ModelLoader.setCustomMeshDefinition((Item) holder, def);
		else registerModels((Item) holder, holder.getVariants());
	}
	
	public static void registerModels(Item item, String[] variants) {
		if(item instanceof ItemBlock && ((ItemBlock) item).getBlock() instanceof IVariantEnumHolder) {
			IVariantEnumHolder holder = (IVariantEnumHolder) ((ItemBlock) item).getBlock();
			Class clazz = holder.getVariantEnum();
			registerVariantsDefaulted(item, (Block) holder, clazz, IVariantEnumHolder.HEADER);
			return;
		}
		
		for(int i = 0; i < variants.length; i++) {
			String name = LibResources.PREFIX_MOD + variants[i];
			ModelResourceLocation loc = new ModelResourceLocation(name, "inventory");
			ModelLoader.setCustomModelResourceLocation(item, i, loc);
			resourceLocations.put(getKey(item, i), loc);
		}
	}
	
    private static <T extends Enum<T> & IStringSerializable> void registerVariantsDefaulted(Item item, Block b, Class<T> enumclazz, String variantHeader) {
        String baseName = GameData.getBlockRegistry().getNameForObject(b).toString();
        for(T e : enumclazz.getEnumConstants()) {
            String variantName = variantHeader + "=" + e.getName();
            ModelResourceLocation loc = new ModelResourceLocation(baseName, variantName);
            int i = e.ordinal();
            ModelLoader.setCustomModelResourceLocation(item, i, loc);
            resourceLocations.put(getKey(item, i), loc);
        }
    }
	
	public static ModelResourceLocation getModelLocation(ItemStack stack) {
		if(stack == null)
			return null;
		
		return getModelLocation(stack.getItem(), stack.getItemDamage());
	}
	
	public static ModelResourceLocation getModelLocation(Item item, int meta) {
		String key = getKey(item, meta);
		if(resourceLocations.containsKey(key))
			return resourceLocations.get(key);
		
		return null;
	}
	
	private static String getKey(Item item, int meta) {
		return item.getRegistryName() + "@" + meta;
	}
	

}
