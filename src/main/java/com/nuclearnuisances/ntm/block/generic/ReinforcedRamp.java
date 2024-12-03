package com.nuclearnuisances.ntm.block.generic;

import com.nuclearnuisances.ntm.block.NTMBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class ReinforcedRamp extends Block {

    private final boolean isOn;

    public ReinforcedRamp(Material blockMaterialIn, boolean isOn) {
        super(blockMaterialIn);
        this.isOn = isOn;

        if (isOn)
        {
            this.setLightLevel(1.0F);
        }

    }

    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            if (this.isOn && !worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, NTMBlocks.REINFORCED_LAMP_OFF.getDefaultState(), 2);
            }
            else if (!this.isOn && worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, NTMBlocks.REINFORCED_LAMP_ON.getDefaultState(), 2);
            }
        }
    }

    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        if (!worldIn.isRemote)
        {
            if (this.isOn && !worldIn.isBlockPowered(pos))
            {
                worldIn.scheduleUpdate(pos, this, 4);
            }
            else if (!this.isOn && worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, NTMBlocks.REINFORCED_LAMP_ON.getDefaultState(), 2);
            }
        }
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            if (this.isOn && !worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, NTMBlocks.REINFORCED_LAMP_OFF.getDefaultState(), 2);
            }
        }
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(NTMBlocks.REINFORCED_LAMP_OFF);
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(NTMBlocks.REINFORCED_LAMP_OFF);
    }

    protected ItemStack getSilkTouchDrop(IBlockState state)
    {
        return new ItemStack(NTMBlocks.REINFORCED_LAMP_OFF);
    }

}
