package com.nuclearnuisances.ntm.block;

import com.nuclearnuisances.ntm.NuclearTechMod;
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

    private static final Supplier<Block> BASIC_ORE = ()->new BlockOre(MapColor.GRAY).setCreativeTab(NuclearTechMod.BLOCK_TAB).setHardness(5.0F).setResistance(10.0F);
    private static final Supplier<Block> GAS_ORE = ()->new BlockOutgas(MapColor.GRAY, true, 5, true).setCreativeTab(NuclearTechMod.BLOCK_TAB).setHardness(5.0F).setResistance(10.0F);

    // public static final Block EXAMPLE_BLOCK = register(new Block(), BASIC_ITEM, "example_block");

    public static final Block ASPHALT = register(new BlockSpeedy(Material.ROCK, MapColor.BLACK, 1.5).setCreativeTab(NuclearTechMod.BLOCK_TAB).setHardness(15.0F).setResistance(120.0F), BASIC_ITEM, "asphalt");
    public static final Block ASPHALT_LIGHT = register(new BlockSpeedy(Material.ROCK, MapColor.BLACK, 1.5).setCreativeTab(NuclearTechMod.BLOCK_TAB).setLightLevel(1).setHardness(15.0F).setResistance(120.0F), BASIC_ITEM, "asphalt_light");
    public static final Block REINFORCED_LAMP_ON = register(new ReinforcedRamp(Material.ROCK, true).setCreativeTab(NuclearTechMod.BLOCK_TAB).setHardness(15.0F).setResistance(80.0F), BASIC_ITEM, "reinforced_lamp_on");
    public static final Block REINFORCED_LAMP_OFF = register(new ReinforcedRamp(Material.ROCK, false).setCreativeTab(NuclearTechMod.BLOCK_TAB).setHardness(15.0F).setResistance(80.0F), BASIC_ITEM, "reinforced_lamp_off");

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
    public static final Block ORE_COAL_OIL = register(new BlockCoalOil(Material.ROCK).setCreativeTab(NuclearTechMod.BLOCK_TAB).setHardness(5.0F).setResistance(10.0F), "ore_coal_oil");
    public static final Block ORE_COAL_OIL_BURNING =register(new BlockCoalBurning(MapColor.GRAY).setCreativeTab(NuclearTechMod.BLOCK_TAB).setLightLevel(10F/15F).setHardness(5.0F).setResistance(10.0F), "ore_coal_oil_burning");

    public static final Block ORE_NETHER_COAL = register(new BlockNetherCoal(MapColor.RED, false, 5, true).setCreativeTab(NuclearTechMod.BLOCK_TAB).setLightLevel(10F/15F).setHardness(0.4F).setResistance(10.0F),"ore_nether_coal");
    public static final Block ORE_NETHER_SMOLDERING = register(new BlockSmolder(Material.ROCK, MapColor.RED).setCreativeTab(NuclearTechMod.BLOCK_TAB).setLightLevel(1F).setHardness(0.4F).setResistance(10.0F), "ore_nether_smoldering");
    public static final Block ORE_NETHER_URANIUM = register(new BlockOutgas(MapColor.RED, true, 5, true).setCreativeTab(NuclearTechMod.BLOCK_TAB).setHardness(0.4F).setResistance(10.0F),"ore_nether_uranium");
    public static final Block ORE_NETHER_URANIUM_SCORCHED = register(new BlockOutgas(MapColor.RED, true, 5, true).setCreativeTab(NuclearTechMod.BLOCK_TAB).setHardness(0.4F).setResistance(10.0F),"ore_nether_uranium_scorched");
    public static final Block ORE_NETHER_PLUTONIUM = register(new BlockOre(MapColor.RED).setCreativeTab(NuclearTechMod.BLOCK_TAB).setHardness(0.4F).setResistance(10.0F), "ore_nether_plutonium");
    public static final Block ORE_NETHER_TUNGSTEN = register(new BlockOre(MapColor.RED).setCreativeTab(NuclearTechMod.BLOCK_TAB).setHardness(0.4F).setResistance(10.0F), "ore_nether_tungsten");
    public static final Block ORE_NETHER_SULFUR = register(new BlockOre(MapColor.RED).setCreativeTab(NuclearTechMod.BLOCK_TAB).setHardness(0.4F).setResistance(10.0F),"ore_nether_sulfur");
    public static final Block ORE_NETHER_FIRE = register(new BlockOre(MapColor.RED).setCreativeTab(NuclearTechMod.BLOCK_TAB).setHardness(0.4F).setResistance(10.0F),"ore_nether_fire");
    public static final Block ORE_NETHER_COBALT = register(new BlockOre(MapColor.RED).setCreativeTab(NuclearTechMod.BLOCK_TAB).setHardness(0.4F).setResistance(10.0F),"ore_nether_cobalt");
    public static final Block ORE_NETHER_SCHRABIDIUM = register(new BlockOre(MapColor.RED).setCreativeTab(NuclearTechMod.BLOCK_TAB).setHardness(15.0F).setResistance(600.0F),"ore_nether_schrabidium");

    //public static final Block ore_meteor = new BlockMeteorOre().setBlockName("ore_meteor").setCreativeTab(MainRegistry.blockTab).setHardness(5.0F).setResistance(10.0F);

    public static final Block STONE_GNEISS = register(new Block(Material.ROCK).setCreativeTab(NuclearTechMod.BLOCK_TAB).setHardness(1.5F).setResistance(10.0F), "stone_gneiss");
    public static final Block ORE_GNEISS_IRON = register(new BlockOre(MapColor.BLACK_STAINED_HARDENED_CLAY).setCreativeTab(NuclearTechMod.BLOCK_TAB).setHardness(1.5F).setResistance(10.0F), "ore_gneiss_iron");
    public static final Block ORE_GNEISS_GOLD = register(new BlockOre(MapColor.BLACK_STAINED_HARDENED_CLAY).setCreativeTab(NuclearTechMod.BLOCK_TAB).setHardness(1.5F).setResistance(10.0F), "ore_gneiss_gold");
    public static final Block ORE_GNEISS_URANIUM = register(new BlockOutgas(MapColor.BLACK_STAINED_HARDENED_CLAY, true, 5, true).setCreativeTab(NuclearTechMod.BLOCK_TAB).setHardness(1.5F).setResistance(10.0F), "ore_gneiss_uranium");
    public static final Block ORE_GNEISS_URANIUM_SCORCHED = register(new BlockOutgas(MapColor.BLACK_STAINED_HARDENED_CLAY, true, 5, true).setCreativeTab(NuclearTechMod.BLOCK_TAB).setHardness(1.5F).setResistance(10.0F), "ore_gneiss_uranium_scorched");
    public static final Block ORE_GNEISS_COPPER = register(new BlockOre(MapColor.BLACK_STAINED_HARDENED_CLAY).setCreativeTab(NuclearTechMod.BLOCK_TAB).setHardness(1.5F).setResistance(10.0F), "ore_gneiss_copper");
    public static final Block ORE_GNEISS_ASBESTOS = register(new BlockOutgas(MapColor.BLACK_STAINED_HARDENED_CLAY, true, 5, true).setCreativeTab(NuclearTechMod.BLOCK_TAB).setHardness(1.5F).setResistance(10.0F), "ore_gneiss_asbestos");
    public static final Block ORE_GNEISS_LITHIUM = register(new BlockOre(MapColor.BLACK_STAINED_HARDENED_CLAY).setCreativeTab(NuclearTechMod.BLOCK_TAB).setHardness(1.5F).setResistance(10.0F), "ore_gneiss_lithium");
    public static final Block ORE_GNEISS_SCHRABIDIUM = register(new BlockOre(MapColor.BLACK_STAINED_HARDENED_CLAY).setHardness(1.5F).setCreativeTab(NuclearTechMod.BLOCK_TAB).setResistance(10.0F), "ore_gneiss_schrabidium");
    public static final Block ORE_GNEISS_RARE = register(new BlockOre(MapColor.BLACK_STAINED_HARDENED_CLAY).setCreativeTab(NuclearTechMod.BLOCK_TAB).setHardness(1.5F).setResistance(10.0F), "ore_gneiss_rare");
    public static final Block ORE_GNEISS_GAS = register(new BlockOre(MapColor.BLACK_STAINED_HARDENED_CLAY).setCreativeTab(NuclearTechMod.BLOCK_TAB).setHardness(1.5F).setResistance(10.0F), "ore_gneiss_gas");

    public static final Block GNEISS_BRICK = register(new Block(Material.ROCK).setCreativeTab(NuclearTechMod.BLOCK_TAB).setHardness(1.5F).setResistance(10.0F), "gneiss_brick");
    public static final Block GNEISS_TILE = register(new Block(Material.ROCK).setCreativeTab(NuclearTechMod.BLOCK_TAB).setHardness(1.5F).setResistance(10.0F), "gneiss_tile");


    public static final Block ASPHALT_STAIR = register(new BlockSpeedyStairs(ASPHALT.getDefaultState(), 1.5).setCreativeTab(NuclearTechMod.BLOCK_TAB), BASIC_ITEM, "asphalt_stairs");

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
