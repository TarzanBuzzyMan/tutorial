package tutorial.generic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "GenericLoader", name = "GenericLoader", version = "0.0.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

//Named Generic, GenericLoader cause thats what it does, loads the mod basically. (I kept losing it in the other files)
public class GenericLoader {
	
	//Needed for TESR. I store this here cause I can... you can put it anywhere else that makes sense, just call it correctly (ie GenericLoader.renderId)
	public static int renderId;
	
	//Normal block I just made it output light...
	public final static Block genericDirt = new GenericBlock(500, 1, Material.ground).setHardness(0.5F).setBlockName("genericDirt").setCreativeTab(CreativeTabs.tabBlock).setLightValue(1.0f);
	
	@Instance("Generic")
	public static GenericLoader instance;
	
	@SidedProxy(clientSide = "tutorial.generic.client.ClientProxy", serverSide = "tutorial.generic.CommonProxy")
	public static CommonProxy proxy;
	
	//I changed load to these 3. Seems more effective and easier to read
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit();
		
		GameRegistry.registerBlock(genericDirt);
	}
	
	@Init
	public void load(FMLInitializationEvent event) {
		proxy.init();
		
		LanguageRegistry.addName(genericDirt, "Generic Dirt");
		MinecraftForge.setBlockHarvestLevel(genericDirt, "shovel", 0);
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit();
	}
	
}