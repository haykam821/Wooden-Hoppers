package io.github.haykam821.woodenhoppers.data;

import io.github.haykam821.woodenhoppers.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.data.server.BlockLootTableGenerator;

public class WoodenHoppersLootTableProvider extends FabricBlockLootTableProvider {
	public WoodenHoppersLootTableProvider(FabricDataGenerator dataGenerator) {
		super(dataGenerator);
	}

	@Override
	protected void generateBlockLootTables() {
		for (ModBlocks modBlock : ModBlocks.values()) {
			this.addDrop(modBlock.getBlock(), BlockLootTableGenerator::nameableContainerDrops);
		}
	}
}