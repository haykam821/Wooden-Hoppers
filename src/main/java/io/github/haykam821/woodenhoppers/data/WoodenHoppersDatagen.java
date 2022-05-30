package io.github.haykam821.woodenhoppers.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

public class WoodenHoppersDatagen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
		FabricTagProvider.BlockTagProvider blockTags = dataGenerator.addProvider(WoodenHoppersBlockTagProvider::new);
		dataGenerator.addProvider(new WoodenHoppersItemTagProvider(dataGenerator, blockTags));

		dataGenerator.addProvider(WoodenHoppersLootTableProvider::new);
		dataGenerator.addProvider(WoodenHoppersModelProvider::new);
	}
}
