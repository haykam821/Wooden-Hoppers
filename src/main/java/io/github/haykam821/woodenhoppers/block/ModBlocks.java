package io.github.haykam821.woodenhoppers.block;

import io.github.haykam821.woodenhoppers.Main;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.util.Identifier;

public enum ModBlocks implements ItemConvertible {
	OAK_HOPPER("oak_hopper", Blocks.OAK_PLANKS),
	SPRUCE_HOPPER("spruce_hopper", Blocks.SPRUCE_PLANKS),
	BIRCH_HOPPER("birch_hopper", Blocks.BIRCH_PLANKS),
	JUNGLE_HOPPER("jungle_hopper", Blocks.JUNGLE_PLANKS),
	ACACIA_HOPPER("acacia_hopper", Blocks.ACACIA_PLANKS),
	DARK_OAK_HOPPER("dark_oak_hopper", Blocks.DARK_OAK_PLANKS),
	MANGROVE_HOPPER("mangrove_hopper", Blocks.MANGROVE_PLANKS),
	BAMBOO_HOPPER("bamboo_hopper", Blocks.BAMBOO_PLANKS, FeatureFlags.UPDATE_1_20),
	CRIMSON_HOPPER("crimson_hopper", Blocks.CRIMSON_PLANKS),
	WARPED_HOPPER("warped_hopper", Blocks.WARPED_PLANKS);

	private final Block base;
	private final Block block;
	private final BlockItem item;

	private ModBlocks(String path, Block base, Block block) {
		Identifier id = new Identifier(Main.MOD_ID, path);

		this.base = base;

		this.block = block;
		Registry.register(Registries.BLOCK, id, block);

		this.item = new BlockItem(block, new Item.Settings());
		Registry.register(Registries.ITEM, id, this.item);
	}

	private ModBlocks(String path, Block base, FeatureFlag... features) {
		this(path, base, new WoodenHopperBlock(createBlockSettings(base, features)));
	}

	public Block getBase() {
		return this.base;
	}

	public Block getBlock() {
		return this.block;
	}

	@Override
	public Item asItem() {
		return this.item;
	}

	public static void initialize() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> {
			entries.addAfter(Items.HOPPER, ModBlocks.values());
		});
	}

	private static Block.Settings createBlockSettings(Block base, FeatureFlag... features) {
		BlockState baseState = base.getDefaultState();

		return Block.Settings.of(baseState.getMaterial(), base.getDefaultMapColor())
			.strength(2)
			.sounds(baseState.getSoundGroup())
			.nonOpaque()
			.requires(features);
	}
}