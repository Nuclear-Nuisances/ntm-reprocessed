package com.nuclearnuisances.ntm.block.generic;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockNetherCoal extends BlockOutgas {
    public BlockNetherCoal(MapColor color, boolean randomTick, int rate, boolean onBreak) {
        super(color, randomTick, rate, onBreak);
    }

//    @Override
//    public Item getItemDropped(int i, Random rand, int j) {
//        return ModItems.coal_infernal;
//    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        super.onEntityWalk(worldIn, pos, entityIn);
        entityIn.setFire(3);
    }

    @Override
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        super.randomDisplayTick(stateIn, worldIn, pos, rand);
        for(EnumFacing dir: EnumFacing.VALUES){
            if(dir == EnumFacing.DOWN){
                continue;
            }
            else if (worldIn.getBlockState(pos.add(dir.getXOffset(), dir.getYOffset(), dir.getZOffset())).getMaterial() != Material.AIR) {
                continue;
            }

            float x = pos.getX();
            float y = pos.getY();
            float z = pos.getZ();

            double ix = x + 0.5F + dir.getXOffset() + rand.nextDouble() - 0.5D;
            double iy = y + 0.5F + dir.getYOffset() + rand.nextDouble() - 0.5D;
            double iz = z + 0.5F + dir.getZOffset() + rand.nextDouble() - 0.5D;

            if(dir.getXOffset() != 0)
                ix = x + 0.5F + dir.getXOffset() * 0.5 + rand.nextDouble() * 0.125 * dir.getXOffset();
            if(dir.getYOffset() != 0)
                iy = y + 0.5F + dir.getYOffset() * 0.5 + rand.nextDouble() * 0.125 * dir.getYOffset();
            if(dir.getZOffset() != 0)
                iz = z + 0.5F + dir.getZOffset() * 0.5 + rand.nextDouble() * 0.125 * dir.getZOffset();

            worldIn.spawnParticle(EnumParticleTypes.FLAME, ix, iy, iz, 0.0, 0.0, 0.0);
            worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, ix, iy, iz, 0.0, 0.0, 0.0);
            worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, ix, iy, iz, 0.0, 0.1, 0.0);

        }
    }

}
