package com.nuclearnuisances.ntm.block.generic;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BlockSpeedy extends Block {

    private final double speed;

    public BlockSpeedy(Material blockMaterialIn, MapColor blockMapColorIn, double speed) {
        super(blockMaterialIn, blockMapColorIn);
        this.speed = speed;
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        super.onEntityWalk(worldIn, pos, entityIn);

        if(!worldIn.isRemote || !(entityIn instanceof EntityPlayer entityPlayer))
            return;

        if(entityPlayer.moveForward != 0 || entityPlayer.moveStrafing != 0) {
            entityIn.motionX *= speed;
            entityIn.motionZ *= speed;
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(TextFormatting.BLUE+ I18n.format("block.speedboost.tooltip", Math.floor((speed - 1) * 100)));
    }
}
