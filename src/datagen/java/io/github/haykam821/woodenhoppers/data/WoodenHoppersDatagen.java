package io.github.haykam821.woodenhoppers.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

public class WoodenHoppersDatagen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
		FabricDataGenerator.Pack pack = dataGenerator.createPack();

		FabricTagProvider.BlockTagProvider blockTags = pack.addProvider(WoodenHoppersBlockTagProvider::new);
		pack.addProvider((output, registries) -> new WoodenHoppersItemTagProvider(output, registries, blockTags));

		pack.addProvider(WoodenHoppersLootTableProvider::new);
		pack.addProvider(WoodenHoppersModelProvider::new);
		pack.addProvider(WoodenHoppersRecipeProvider::new);
	}
}
