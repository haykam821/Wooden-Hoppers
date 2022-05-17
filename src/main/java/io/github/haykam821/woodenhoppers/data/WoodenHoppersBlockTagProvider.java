package io.github.haykam821.woodenhoppers.data;

import io.github.haykam821.woodenhoppers.block.ModBlocks;
import io.github.haykam821.woodenhoppers.tag.WoodenHoppersBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.FabricTagBuilder;
import net.minecraft.block.Block;
import net.minecraft.tag.BlockTags;

public class WoodenHoppersBlockTagProvider extends FabricTagProvider.BlockTagProvider {
	public WoodenHoppersBlockTagProvider(FabricDataGenerator dataGenerator) {
		super(dataGenerator);
	}

	@Override
	protected void generateTags() {
		FabricTagBuilder<Block> builder = this.getOrCreateTagBuilder(WoodenHoppersBlockTags.WOODEN_HOPPERS);
		for (ModBlocks modBlock : ModBlocks.values()) {
			builder.add(modBlock.getBlock());
		}

		this.getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
			.addTag(WoodenHoppersBlockTags.WOODEN_HOPPERS);

		this.getOrCreateTagBuilder(BlockTags.NON_FLAMMABLE_WOOD)
			.add(ModBlocks.CRIMSON_HOPPER.getBlock())
			.add(ModBlocks.WARPED_HOPPER.getBlock());
	}
}
