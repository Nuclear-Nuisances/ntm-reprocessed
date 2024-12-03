package com.nuclearnuisances.ntm.block;

import com.nuclearnuisances.ntm.Tags;
import com.nuclearnuisances.ntm.block.generic.BlockSpeedy;
import com.nuclearnuisances.ntm.block.generic.BlockSpeedyStairs;
import com.nuclearnuisances.ntm.block.generic.ReinforcedRamp;
import com.nuclearnuisances.ntm.item.NTMItems;
import com.nuclearnuisances.ntm.util.SupplierInput;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneLight;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class NTMBlocks {

    private static final List<Block> BLOCKS = new ArrayList<>();

    private static final SupplierInput<Block, Item> BASIC_ITEM = ItemBlock::new;

    // public static final Block EXAMPLE_BLOCK = register(new Block(), BASIC_ITEM, "example_block");

    public static final Block ASPHALT = register(new BlockSpeedy(Material.ROCK, MapColor.BLACK, 1.5).setHardness(15.0F).setResistance(120.0F), BASIC_ITEM, "asphalt");
    public static final Block ASPHALT_LIGHT = register(new BlockSpeedy(Material.ROCK, MapColor.BLACK, 1.5).setLightLevel(1).setHardness(15.0F).setResistance(120.0F), BASIC_ITEM, "asphalt_light");
    public static final Block REINFORCED_LAMP_ON = register(new ReinforcedRamp(Material.ROCK, true).setHardness(15.0F).setResistance(80.0F), BASIC_ITEM, "reinforced_lamp_on");
    public static final Block REINFORCED_LAMP_OFF = register(new ReinforcedRamp(Material.ROCK, false).setHardness(15.0F).setResistance(80.0F), BASIC_ITEM, "reinforced_lamp_off");

    public static final Block ASPHALT_STAIR = register(new BlockSpeedyStairs(ASPHALT.getDefaultState(), 1.5), BASIC_ITEM, "asphalt_stairs");

    public static <T extends Block> T register(T block, @Nullable SupplierInput<Block, Item> itemSupplier, @NotNull String name) {
        ResourceLocation location = new ResourceLocation(Tags.MOD_ID, name);
        return register(block, itemSupplier, location);
    }

    public static <T extends Block> T register(T block, @Nullable SupplierInput<Block, Item> itemSupplier, @NotNull ResourceLocation name) {
        block.setRegistryName(name).setTranslationKey(name.getNamespace() + "." + name.getPath());
        BLOCKS.add(block);
        if (itemSupplier != null) NTMItems.register(itemSupplier.get(block), name);
        return block;
    }

    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();
        BLOCKS.forEach(registry::register);
    }
}
