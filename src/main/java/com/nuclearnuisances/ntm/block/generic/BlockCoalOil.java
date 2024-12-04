package com.nuclearnuisances.ntm.block.generic;

import java.util.Random;

import com.nuclearnuisances.ntm.block.NTMBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCoalOil extends Block {

	public BlockCoalOil(Material mat) {
		super(mat, MapColor.GRAY);
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(worldIn, pos, state, rand);
		worldIn.setBlockState(pos, NTMBlocks.ORE_COAL_OIL_BURNING.getDefaultState());
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Items.COAL;
	}

	@Override
	public int quantityDropped(Random rand) {
		return 2 + rand.nextInt(2);
	}
}
