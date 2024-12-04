package api.ntm.block;

import api.ntm.block.IMiningDrill;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IDrillInteraction {

	/**
	 * Whether the breaking of the block should be successful. Will destroy the block and not drop anything from clusters.
	 * Should use a random function, otherwise the clusters will stay there indefinitely printing free ore.
	 * @param world
	 * @param pos
	 * @param drill Might be a tool, tile entity or anything that breaks blocks
	 * @return
	 */
	public boolean canBreak(World world, BlockPos pos, int meta, IMiningDrill drill);
	
	/**
	 * Returns an itemstack, usually when the block is not destroyed. Laser drills may drop this and mechanical drills will add it to their inventories.
	 * @param world
	 * @param pos
	 * @param drill Might be a tool, tile entity or anything that breaks blocks
	 * @return
	 */
	public ItemStack extractResource(World world, BlockPos pos, int meta, IMiningDrill drill);
	
	/**
	 * The hardness that should be considered instead of the hardness value of the block itself
	 * @param world
	 * @param pos
	 * @param meta
	 * @param drill
	 * @return
	 */
	public float getRelativeHardness(World world, BlockPos pos, int meta, IMiningDrill drill);
}
