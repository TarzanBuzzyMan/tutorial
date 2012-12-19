package tutorial.generic;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

//Make GenericBlock extend BlockContainer
public class GenericBlock extends BlockContainer {
	
	public GenericBlock(int id, int meta, Material material) {
		super(id, meta, material);
	}
	
	//This method is added when extending BlockContainer
	@Override
	public TileEntity createNewTileEntity(World w) {
		//return your TileEntity class
		return new TileEntityTorchHolder();
	}
	
	//Needed for TESR
	@Override
	public int getRenderType() {
		return GenericLoader.renderId;
	}
	
	//Only called if normal block?
	@Override
	public String getTextureFile() {
		return CommonProxy.BLOCK_PNG;
	}
	
	//Make these both false
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
	
}
