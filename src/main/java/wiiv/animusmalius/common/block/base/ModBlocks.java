/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Psi Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Psi
 * 
 * Psi is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 * 
 * File Created @ [09/01/2016, 23:13:36 (GMT)]
 */
package wiiv.animusmalius.common.block.base;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wiiv.animusmalius.common.block.BlockMaterial;
import wiiv.animusmalius.common.lib.LibResources;

public class ModBlocks {

	public static BlockMod materialBlock;  

	public static void init() {
		//materialBlock = new BlockMaterial();
		

		//initTileEntities();
	}

	private static void initTileEntities() {
		//registerTile(TileCADAssembler.class, LibBlockNames.CAD_ASSEMBLER);
	}
	
	private static void registerTile(Class<? extends TileEntity> clazz, String key) {
		//GameRegistry.registerTileEntity(clazz, LibResources.PREFIX_MOD + key);
	}
	
}
