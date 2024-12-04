package com.nuclearnuisances.ntm.creativetab;

import com.nuclearnuisances.ntm.block.NTMBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BlockTab extends CreativeTabs {
    public BlockTab(String label) {
        super(label);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Item.getItemFromBlock(NTMBlocks.ORE_URANIUM));
    }
}
