package com.nuclearnuisances.ntm.block;

import com.nuclearnuisances.ntm.Tags;
import com.nuclearnuisances.ntm.block.generic.*;
import com.nuclearnuisances.ntm.item.NTMItems;
import com.nuclearnuisances.ntm.util.SupplierInput;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
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
import java.util.function.Supplier;

public class NTMBlocks {

    private static final List<Block> BLOCKS = new ArrayList<>();

    private static final SupplierInput<Block, Item> BASIC_ITEM = ItemBlock::new;

    private static final Supplier<Block> BASIC_ORE = ()->new BlockOre(MapColor.GRAY).setHardness(5.0F).setResistance(10.0F);
    private static final Supplier<Block> GAS_ORE = ()->new BlockOutgas(MapColor.GRAY, true, 5, true).setHardness(5.0F).setResistance(10.0F);

    // public static final Block EXAMPLE_BLOCK = register(new Block(), BASIC_ITEM, "example_block");

    public static final Block ASPHALT = register(new BlockSpeedy(Material.ROCK, MapColor.BLACK, 1.5).setHardness(15.0F).setResistance(120.0F), BASIC_ITEM, "asphalt");
    public static final Block ASPHALT_LIGHT = register(new BlockSpeedy(Material.ROCK, MapColor.BLACK, 1.5).setLightLevel(1).setHardness(15.0F).setResistance(120.0F), BASIC_ITEM, "asphalt_light");
    public static final Block REINFORCED_LAMP_ON = register(new ReinforcedRamp(Material.ROCK, true).setHardness(15.0F).setResistance(80.0F), BASIC_ITEM, "reinforced_lamp_on");
    public static final Block REINFORCED_LAMP_OFF = register(new ReinforcedRamp(Material.ROCK, false).setHardness(15.0F).setResistance(80.0F), BASIC_ITEM, "reinforced_lamp_off");

    public static final Block ORE_URANIUM = registerGasOre("ore_uranium");
    public static final Block ORE_URANIUM_SCORCHED = registerGasOre("ore_uranium_scorched");

    public static final Block ORE_TITANIUM = registerBasicOre("ore_titanium");
    public static final Block ORE_SULFUR = registerBasicOre("ore_sulfur");
    public static final Block ORE_THORIUM = registerBasicOre("ore_thorium");

    public static final Block ORE_NITER = registerBasicOre("ore_niter");
    public static final Block ORE_COPPER = registerBasicOre("ore_copper");
    public static final Block ORE_TUNGSTEN = registerBasicOre("ore_tungsten");
    public static final Block ORE_ALUMINIUM = registerBasicOre("ore_aluminium");
    public static final Block ORE_FLUORITE = registerBasicOre("ore_fluorite");
    public static final Block ORE_LEAD = registerBasicOre("ore_lead");
    public static final Block ORE_SCHRABIDIUM = registerBasicOre("ore_schrabidium");
    public static final Block ORE_BERYLLIUM = registerBasicOre("ore_beryllium");
    public static final Block ORE_LIGNITE = registerBasicOre("ore_lignite");
    public static final Block ORE_ASBESTOS = registerGasOre("ore_asbestos");
    public static final Block ORE_COAL_OIL = register(new BlockCoalOil(Material.ROCK).setHardness(5.0F).setResistance(10.0F), "ore_coal_oil");
    public static final Block ORE_COAL_OIL_BURNING =register(new BlockCoalBurning(MapColor.GRAY).setLightLevel(10F/15F).setHardness(5.0F).setResistance(10.0F), "ore_coal_oil_burning");

    public static final Block ASPHALT_STAIR = register(new BlockSpeedyStairs(ASPHALT.getDefaultState(), 1.5), BASIC_ITEM, "asphalt_stairs");

    public static Block registerBasicOre(@NotNull String name) {
        return register(BASIC_ORE.get(), BASIC_ITEM, name);
    }

    public static Block registerGasOre(@NotNull String name) {
        return register(GAS_ORE.get(), BASIC_ITEM, name);
    }

    public static <T extends Block> T register(T block, @NotNull String name) {
        ResourceLocation location = new ResourceLocation(Tags.MOD_ID, name);
        return register(block, BASIC_ITEM, location);
    }

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
