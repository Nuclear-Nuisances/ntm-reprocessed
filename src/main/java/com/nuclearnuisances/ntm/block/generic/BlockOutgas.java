package com.nuclearnuisances.ntm.block.generic;

import com.nuclearnuisances.ntm.block.NTMBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockOutgas extends BlockOre {

    boolean randomTick;
    int rate;
    boolean onBreak;
    boolean onNeighbour;

    public BlockOutgas(MapColor color, boolean randomTick, int rate, boolean onBreak) {
        super(color);
        this.setTickRandomly(randomTick);
        this.randomTick = randomTick;
        this.rate = rate;
        this.onBreak = onBreak;
        this.onNeighbour = false;
    }

    public BlockOutgas(MapColor mat, boolean randomTick, int rate, boolean onBreak, boolean onNeighbour) {
        this(mat, randomTick, rate, onBreak);
        this.onNeighbour = onNeighbour;
    }

    public int tickRate(World world) {
        return rate;
    }

    protected Block getGas() {

        /*
        if(this == NTMBlocks.ore_uranium || this == NTMBlocks.ore_uranium_scorched ||
                this == NTMBlocks.ore_gneiss_uranium || this == NTMBlocks.ore_gneiss_uranium_scorched ||
                this == NTMBlocks.ore_nether_uranium || this == NTMBlocks.ore_nether_uranium_scorched) {
            return NTMBlocks.gas_radon;
        }
        else if(this == NTMBlocks.block_corium_cobble)
            return NTMBlocks.gas_radon;

        else if(this == NTMBlocks.ancient_scrap)
            return NTMBlocks.gas_radon_tomb;

        else if(this == NTMBlocks.ore_coal_oil_burning || this == NTMBlocks.ore_nether_coal) {
            return NTMBlocks.gas_monoxide;
        }

        else if(this == NTMBlocks.ore_asbestos || this == NTMBlocks.ore_gneiss_asbestos ||
                this == NTMBlocks.block_asbestos || this == NTMBlocks.deco_asbestos ||
                this == NTMBlocks.brick_asbestos || this == NTMBlocks.tile_lab ||
                this == NTMBlocks.tile_lab_cracked || this == NTMBlocks.tile_lab_broken) {
            return NTMBlocks.gas_asbestos;
        }

         */

        return Blocks.AIR;
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        super.onEntityWalk(worldIn, pos, entityIn);
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

//        if(this.randomTick && getGas().getbLOCK == NTMBlocks.GAS_ASBESTOS) {
//
//            if(worldIn.getBlockState(pos.up()) == Blocks.AIR) {
//
//                if(worldIn.rand.nextInt(10) == 0)
//                    worldIn.setBlockState(pos.up(), NTMBlocks.GAS_ASBESTOS.getDefaultState());
//
//                for(int i = 0; i < 5; i++)
//                    worldIn.spawnParticle(EnumParticleTypes.TOWN_AURA, x + worldIn.rand.nextFloat(), y + 1.1, z + worldIn.rand.nextFloat(), 0.0D, 0.0D, 0.0D);
//            }
//        }
    }
}
