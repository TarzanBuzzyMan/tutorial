package tutorial.generic.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.src.ModLoader;
import net.minecraftforge.client.MinecraftForgeClient;
import tutorial.generic.CommonProxy;
import tutorial.generic.GenericLoader;
import tutorial.generic.RenderTorchHolder;
import tutorial.generic.TileEntityTorchHolder;

public class ClientProxy extends CommonProxy {
	
	public void preInit() {
		//Needed for TESR.
		GenericLoader.renderId = RenderingRegistry.getNextAvailableRenderId();
		// Only needed for ISBHR?
		RenderingRegistry.registerBlockHandler(new CustomBlockRenderer());
		
		MinecraftForgeClient.preloadTexture(MODEL_PNG);
		MinecraftForgeClient.preloadTexture(ITEMS_PNG);
		MinecraftForgeClient.preloadTexture(BLOCK_PNG);
	}
	
	@Override
	public void init() {
		//Needed for TESR.
		ClientRegistry.registerTileEntity(TileEntityTorchHolder.class, "TorchHolder", new RenderTorchHolder());
	}
	
	public void postInit() {
		
	}
	
}