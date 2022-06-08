package io.github.haykam821.woodenhoppers.data;

import io.github.haykam821.woodenhoppers.tag.WoodenHoppersBlockTags;
import io.github.haykam821.woodenhoppers.tag.WoodenHoppersItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.ItemTags;

public class WoodenHoppersItemTagProvider extends FabricTagProvider.ItemTagProvider {
	public WoodenHoppersItemTagProvider(FabricDataGenerator dataGenerator, FabricTagProvider.BlockTagProvider blockTags) {
		super(dataGenerator, blockTags);
	}

	@Override
	protected void generateTags() {
		this.copy(WoodenHoppersBlockTags.WOODEN_HOPPERS, WoodenHoppersItemTags.WOODEN_HOPPERS);
		this.copy(BlockTags.NON_FLAMMABLE_WOOD, ItemTags.NON_FLAMMABLE_WOOD);
	}
}
