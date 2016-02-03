/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Psi Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Psi
 * 
 * Psi is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 * 
 * File Created @ [08/01/2016, 21:22:59 (GMT)]
 */
package wiiv.animusmalius.common.core.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import wiiv.animusmalius.common.block.base.ModBlocks;
import wiiv.animusmalius.common.item.base.ModItems;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		
		//ConfigHandler.init(event.getSuggestedConfigurationFile());
		
		ModItems.init();
		ModBlocks.init();
		//ModEntities.init();
		//ModCraftingRecipes.init();

		//NetworkRegistry.INSTANCE.registerGuiHandler(AnimusMalius.instance, new GuiHandler());
		
		//MinecraftForge.EVENT_BUS.register(new PlayerDataHandler.EventHandler());
	}
	
	public EntityPlayer getClientPlayer() {
		return null;
	}
}	