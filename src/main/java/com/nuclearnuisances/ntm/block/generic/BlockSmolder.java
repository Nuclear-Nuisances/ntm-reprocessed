package com.nuclearnuisances.ntm.block.generic;

import com.nuclearnuisances.ntm.item.NTMItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockSmolder extends Block {
    public BlockSmolder(Material materialIn, MapColor color) {
        super(materialIn, color);
    }

    @Override
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        super.randomDisplayTick(stateIn, worldIn, pos, rand);

        if(worldIn.getBlockState(pos.up()).getMaterial() == Material.AIR) {

            worldIn.spawnParticle(EnumParticleTypes.LAVA, pos.getX() + 0.25 + rand.nextDouble() * 0.5, pos.getY() + 1.1, pos.getZ() + 0.25 + rand.nextDouble() * 0.5, 0.0, 0.0, 0.0);
            worldIn.spawnParticle(EnumParticleTypes.FLAME, pos.getX() + 0.25 + rand.nextDouble() * 0.5, pos.getY() + 1.1, pos.getZ() + 0.25 + rand.nextDouble() * 0.5, 0.0, 0.0, 0.0);
        }
    }

//    @Override
//    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
//        return NTMItems.POWDER_FIRE;
//    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        super.onEntityWalk(worldIn, pos, entityIn);
        entityIn.setFire(3);
    }
}
