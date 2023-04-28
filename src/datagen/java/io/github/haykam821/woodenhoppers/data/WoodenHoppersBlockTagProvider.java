package io.github.haykam821.woodenhoppers.data;

import java.util.concurrent.CompletableFuture;

import io.github.haykam821.woodenhoppers.block.ModBlocks;
import io.github.haykam821.woodenhoppers.tag.WoodenHoppersBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.registry.tag.BlockTags;

public class WoodenHoppersBlockTagProvider extends FabricTagProvider.BlockTagProvider {
	public WoodenHoppersBlockTagProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registries) {
		super(dataOutput, registries);
	}

	@Override
	protected void configure(WrapperLookup lookup) {
		FabricTagBuilder builder = this.getOrCreateTagBuilder(WoodenHoppersBlockTags.WOODEN_HOPPERS);
		for (ModBlocks modBlock : ModBlocks.values()) {
			builder.add(modBlock.getBlock());
		}

		this.getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
			.addTag(WoodenHoppersBlockTags.WOODEN_HOPPERS);
	}
}
