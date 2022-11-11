package io.github.haykam821.woodenhoppers.data;

import io.github.haykam821.woodenhoppers.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class WoodenHoppersLootTableProvider extends FabricBlockLootTableProvider {
	public WoodenHoppersLootTableProvider(FabricDataOutput dataOutput) {
		super(dataOutput);
	}

	@Override
	public void generate() {
		for (ModBlocks modBlock : ModBlocks.values()) {
			this.addDrop(modBlock.getBlock(), this::nameableContainerDrops);
		}
	}
}