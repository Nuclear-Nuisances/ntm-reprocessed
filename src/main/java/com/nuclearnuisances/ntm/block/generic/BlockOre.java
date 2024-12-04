package com.nuclearnuisances.ntm.block.generic;

import com.nuclearnuisances.ntm.util.SupplierBiInput;
import com.nuclearnuisances.ntm.util.SupplierInput;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Random;
import java.util.function.Consumer;

// WIP
public class BlockOre extends Block {

    @Nullable
    private SupplierBiInput<Random, Integer, ItemStack> loot = null;
    @Nullable
    private Consumer<Entity> walkEffect = null;
    public boolean allowFortune = true;

    public BlockOre(Material mat) {
        this(mat, false);
    }
    public BlockOre(Material mat, boolean tick) {
        super(mat);
        this.setTickRandomly(tick);
    }

    public BlockOre noFortune() {
        this.allowFortune = false;
        return this;
    }

    public BlockOre setLoot(SupplierBiInput<Random, Integer, ItemStack> loot){
        this.loot = loot;
        return this;
    }

    public BlockOre setWalkEffect(Consumer<Entity> effect){
        this.walkEffect = effect;
        return this;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return this.loot == null? Item.getItemFromBlock(this):this.loot.get(rand, fortune).getItem();
    }

    @Override
    public int quantityDropped(IBlockState state, int fortune, Random random) {
        return this.loot == null? super.quantityDropped(state, fortune, random):this.loot.get(random, fortune).getCount();
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random) {
        return this.loot == null? super.quantityDroppedWithBonus(fortune, random):this.loot.get(random, fortune).getCount();
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        super.onEntityWalk(worldIn, pos, entityIn);
        if (this.walkEffect != null){
            this.walkEffect.accept(entityIn);
        }
    }
}
