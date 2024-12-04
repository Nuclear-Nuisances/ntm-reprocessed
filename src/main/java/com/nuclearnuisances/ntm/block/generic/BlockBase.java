package com.nuclearnuisances.ntm.block.generic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBase extends Block {
    private boolean beaconable = false;
    private boolean canSpawn = true;

    public BlockBase() {
        super(Material.ROCK);
    }

    public BlockBase(Material material) {
        super(material);
    }

    /**
     * Daisychainable setter for making the block a beacon base block
     * @return
     */
    public BlockBase setBeaconable() {
        this.beaconable = true;
        return this;
    }

    public BlockBase noMobSpawn() {
        this.canSpawn = false;
        return this;
    }

    @Override
    public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, EntityLiving.SpawnPlacementType type) {
        return this.canSpawn && super.canCreatureSpawn(state, world, pos, type);
    }

    @Override
    public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
        return this.beaconable;
    }

    /**
     * Sets the block to air and drops it
     * @param world
     * @param pos
     */
    public void dismantle(World world, BlockPos pos) {

        world.setBlockToAir(pos);

        ItemStack itemstack = new ItemStack(this, 1);
        float f = world.rand.nextFloat() * 0.6F + 0.2F;
        float f1 = world.rand.nextFloat() * 0.2F;
        float f2 = world.rand.nextFloat() * 0.6F + 0.2F;

        EntityItem entityitem = new EntityItem(world, pos.getX() + f, pos.getY() + f1 + 1, pos.getZ() + f2, itemstack);

        float f3 = 0.05F;
        entityitem.motionX = (float) world.rand.nextGaussian() * f3;
        entityitem.motionY = (float) world.rand.nextGaussian() * f3 + 0.2F;
        entityitem.motionZ = (float) world.rand.nextGaussian() * f3;

        if(!world.isRemote)
            world.spawnEntity(entityitem);
    }
}
