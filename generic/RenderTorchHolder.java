package tutorial.generic;

import org.lwjgl.opengl.GL11;


import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

//Make your renderer class extend TileEntitySpecialRenderer
public class RenderTorchHolder extends TileEntitySpecialRenderer {
	
	//Store model
	private ModelTorchHolder mTorchHolder;
	
	//Instantiate model
	public RenderTorchHolder() {
		mTorchHolder = new ModelTorchHolder();
	}
	
	//Added by extending TileEntitySpecialRenderer
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
		
		bindTextureByName(CommonProxy.MODEL_PNG); //Gets texture for model
		GL11.glPushMatrix(); //is equal to { in normal code
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F); //Change the + numbers on x,y,z to move your model to correct place
		GL11.glScalef(1.0F, -1F, -1F); //Dunno might need it
		GL11.glRotatef(0f, 0f, 1f, 0f); //Dunno might need it
		mTorchHolder.renderModel(0.0625F); //Call on the method you added to your model instance and pass it 0.0625F and only 0.0625F
		GL11.glPopMatrix(); //is equal to } in normal code
	}
	
}
