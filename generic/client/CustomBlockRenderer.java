package tutorial.generic.client;

import org.lwjgl.opengl.GL11;

import tutorial.generic.CommonProxy;
import tutorial.generic.GenericBlock;
import tutorial.generic.GenericLoader;
import tutorial.generic.ModelTorchHolder;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

//Implement ISBHR in this class
public class CustomBlockRenderer implements ISimpleBlockRenderingHandler {
	private ModelTorchHolder mTorchHolder;
	
	//Put this code in like was in Renderer and modify accordingly.
	//Use GL11.glBindTexture() instead of bindTextureByName
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		System.out.println("Drawing in inventory");
		mTorchHolder = new ModelTorchHolder();
		GL11.glPushMatrix();
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, FMLClientHandler.instance().getClient().renderEngine.getTexture(CommonProxy.MODEL_PNG));
		GL11.glRotatef(0f, 0f, 1f, 0f);
		mTorchHolder.renderModel(0.0625F);
		GL11.glPopMatrix();
		
	}
	
	//This method only returns false because you have TESR instead
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		return false;
	}
	
	//This makes item in inventory appear 3D or 2D, change to your liking
	public boolean shouldRender3DInInventory() {
		return true;
	}
	
	//Return that ID again
	public int getRenderId() {
		return GenericLoader.renderId;
	}
	
}
