package io.github.haykam821.woodenhoppers.data;

import java.util.Optional;

import io.github.haykam821.woodenhoppers.Main;
import io.github.haykam821.woodenhoppers.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.BlockStateVariantMap;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.VariantsBlockStateSupplier;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public class WoodenHoppersModelProvider extends FabricModelProvider {
	public static final Model WOODEN_HOPPER = createModel("wooden_hopper", Optional.empty(), TextureKey.ALL);
	public static final Model WOODEN_HOPPER_SIDE = createModel("wooden_hopper_side", Optional.of("_side"), TextureKey.ALL);

	public WoodenHoppersModelProvider(FabricDataGenerator dataGenerator) {
		super(dataGenerator);
	}

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator modelGenerator) {
		for (ModBlocks modBlock : ModBlocks.values()) {
			WoodenHoppersModelProvider.registerWoodenHopper(modelGenerator, modBlock.getBlock(), modBlock.getBase());
		}
	}

	@Override
	public void generateItemModels(ItemModelGenerator modelGenerator) {
		return;
	}

	public static void registerWoodenHopper(BlockStateModelGenerator modelGenerator, Block block, Block base) {
		TextureMap textures = TextureMap.all(base);

		Identifier id = WOODEN_HOPPER.upload(block, textures, modelGenerator.modelCollector);
		modelGenerator.registerParentedItemModel(block, id);

		Identifier sideId = WOODEN_HOPPER_SIDE.upload(block, textures, modelGenerator.modelCollector);

		BlockStateVariantMap variants = BlockStateVariantMap.create(Properties.HOPPER_FACING)
			.register(Direction.DOWN, createVariant(id))
			.register(Direction.NORTH, createVariantRotated(sideId, VariantSettings.Rotation.R0))
			.register(Direction.EAST, createVariantRotated(sideId, VariantSettings.Rotation.R90))
			.register(Direction.SOUTH, createVariantRotated(sideId, VariantSettings.Rotation.R180))
			.register(Direction.WEST, createVariantRotated(sideId, VariantSettings.Rotation.R270));

		modelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(variants));
	}

	private static BlockStateVariant createVariant(Identifier modelId) {
		return BlockStateVariant.create().put(VariantSettings.MODEL, modelId);
	}

	private static BlockStateVariant createVariantRotated(Identifier modelId, VariantSettings.Rotation rotation) {
		return createVariant(modelId).put(VariantSettings.Y, rotation);
	}

	private static Model createModel(String parent, Optional<String> variant, TextureKey... requiredTextures) {
		Identifier parentId = new Identifier(Main.MOD_ID, "block/" + parent);
		return new Model(Optional.of(parentId), variant, requiredTextures);
	}
}
