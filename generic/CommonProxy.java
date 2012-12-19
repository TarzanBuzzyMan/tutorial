package tutorial.generic;

import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {
	// Client stuff
	public static String ITEMS_PNG = "/tutorial/generic/items.png";
	public static String BLOCK_PNG = "/tutorial/generic/block.png";
	public static String MODEL_PNG = "/tutorial/generic/model.png";
	
	//Server stuff
	public void preInit() {
		
	}
	
	public void init() {
		GameRegistry.registerTileEntity(TileEntityTorchHolder.class, "TileEntityTorchHolder");
		
	}
	
	public void postInit() {
		
	}
	
}