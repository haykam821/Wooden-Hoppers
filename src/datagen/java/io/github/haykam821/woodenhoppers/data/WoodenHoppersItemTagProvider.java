package io.github.haykam821.woodenhoppers.data;

import java.util.concurrent.CompletableFuture;

import io.github.haykam821.woodenhoppers.block.ModBlocks;
import io.github.haykam821.woodenhoppers.tag.WoodenHoppersBlockTags;
import io.github.haykam821.woodenhoppers.tag.WoodenHoppersItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.registry.RegistryWrapper;
import net.minecraft.util.registry.RegistryWrapper.WrapperLookup;

public class WoodenHoppersItemTagProvider extends FabricTagProvider.ItemTagProvider {
	public WoodenHoppersItemTagProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registries, FabricTagProvider.BlockTagProvider blockTags) {
		super(dataOutput, registries, blockTags);
	}

	@Override
	protected void configure(WrapperLookup lookup) {
		this.copy(WoodenHoppersBlockTags.WOODEN_HOPPERS, WoodenHoppersItemTags.WOODEN_HOPPERS);

		this.getOrCreateTagBuilder(ItemTags.NON_FLAMMABLE_WOOD)
			.add(ModBlocks.CRIMSON_HOPPER.asItem())
			.add(ModBlocks.WARPED_HOPPER.asItem());
	}
}
