package io.github.haykam821.woodenhoppers.block;

import io.github.haykam821.woodenhoppers.Main;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public enum ModBlocks {
	OAK_HOPPER("oak_hopper", Material.WOOD, Blocks.OAK_PLANKS),
	SPRUCE_HOPPER("spruce_hopper", Material.WOOD, Blocks.SPRUCE_PLANKS),
	BIRCH_HOPPER("birch_hopper", Material.WOOD, Blocks.BIRCH_PLANKS),
	JUNGLE_HOPPER("jungle_hopper", Material.WOOD, Blocks.JUNGLE_PLANKS),
	ACACIA_HOPPER("acacia_hopper", Material.WOOD, Blocks.ACACIA_PLANKS),
	DARK_OAK_HOPPER("dark_oak_hopper", Material.WOOD, Blocks.DARK_OAK_PLANKS),
	CRIMSON_HOPPER("crimson_hopper", Material.NETHER_WOOD, Blocks.CRIMSON_PLANKS),
	WARPED_HOPPER("warped_hopper", Material.NETHER_WOOD, Blocks.WARPED_PLANKS);

	private final Block block;
	private final BlockItem item;

	private ModBlocks(String path, Block block) {
		Identifier id = new Identifier(Main.MOD_ID, path);

		this.block = block;
		Registry.register(Registry.BLOCK, id, block);

		this.item = new BlockItem(block, new Item.Settings().group(ItemGroup.REDSTONE));
		Registry.register(Registry.ITEM, id, this.item);
	}

	private ModBlocks(String path, Material material, Block base) {
		this(path, new WoodenHopperBlock(Block.Settings.of(material, base.getDefaultMapColor()).strength(2).sounds(BlockSoundGroup.WOOD).nonOpaque()));
	}

	public Block getBlock() {
		return this.block;
	}

	public BlockItem getItem() {
		return this.item;
	}

	public static void initialize() {
		return;
	}
}