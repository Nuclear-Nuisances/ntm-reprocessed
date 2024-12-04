package com.nuclearnuisances.ntm.block.generic;

import java.util.Random;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCoalBurning extends BlockOutgas {

	public BlockCoalBurning(MapColor mat) {
		super(mat, false, 1, false);
		this.setTickRandomly(true);
	}


	@Override
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		super.randomDisplayTick(stateIn, worldIn, pos, rand);
		for(EnumFacing dir:EnumFacing.VALUES){
			if(dir == EnumFacing.DOWN) continue;
			else if (worldIn.getBlockState(pos.offset(dir)).getBlock() != Blocks.AIR) continue;

            double ix = pos.getX() + 0.5F + dir.getXOffset() + rand.nextDouble() - 0.5D;
			double iy = pos.getY() + 0.5F + dir.getYOffset() + rand.nextDouble() - 0.5D;
			double iz = pos.getZ() + 0.5F + dir.getZOffset() + rand.nextDouble() - 0.5D;

			if(dir.getXOffset() != 0)
				ix = pos.getX() + 0.5F + dir.getXOffset() * 0.5 + rand.nextDouble() * 0.125 * dir.getXOffset();
			if(dir.getYOffset() != 0)
				iy = pos.getY() + 0.5F + dir.getYOffset() * 0.5 + rand.nextDouble() * 0.125 * dir.getYOffset();
			if(dir.getZOffset() != 0)
				iz = pos.getZ() + 0.5F + dir.getZOffset() * 0.5 + rand.nextDouble() * 0.125 * dir.getZOffset();

			worldIn.spawnParticle(EnumParticleTypes.FLAME, ix, iy, iz, 0.0, 0.0, 0.0);
			worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, ix, iy, iz, 0.0, 0.0, 0.0);
			worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, ix, iy, iz, 0.0, 0.1, 0.0);

		}

	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Items.AIR;
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		super.breakBlock(worldIn, pos, state);

		worldIn.setBlockState(pos, Blocks.FIRE.getDefaultState());

		for(int ix = -2; ix <= 2; ix++) {
			for(int iy = -2; iy <= 2; iy++) {
				for(int iz = -2; iz <= 2; iz++) {
					if(Math.abs(ix + iy + iz) < 5 && worldIn.getBlockState(pos.add(ix, iy, iz)).getBlock() == Blocks.AIR) {
						worldIn.setBlockState(pos.add(ix, iy, iz), this.getGas().getDefaultState());
					}
				}
			}
		}

	}

	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		entityIn.setFire(3);
	}
}
