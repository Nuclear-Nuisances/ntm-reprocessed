package com.nuclearnuisances.ntm.block.generic;

import api.ntm.item.IDepthRockTool;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BlockDepth extends Block {
    public BlockDepth() {
        super(Material.ROCK);
        this.setBlockUnbreakable();
        this.setResistance(10.0F);
    }

    @Override
    public float getPlayerRelativeBlockHardness(IBlockState state, EntityPlayer player, World worldIn, BlockPos pos) {
        if(!player.getHeldItem(EnumHand.MAIN_HAND).isEmpty() && player.getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof IDepthRockTool) {
            if(((IDepthRockTool)player.getHeldItem(EnumHand.MAIN_HAND).getItem()).canBreakRock(worldIn, player, player.getHeldItem(EnumHand.MAIN_HAND), this, pos))
                return (float) (1D / 50D);
        }
        return super.getPlayerRelativeBlockHardness(state, player, worldIn, pos);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFormatting.YELLOW+ I18n.format("trait.tile.depth"));
    }
}
