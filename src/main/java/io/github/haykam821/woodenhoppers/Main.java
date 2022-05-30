package io.github.haykam821.woodenhoppers;

import io.github.haykam821.woodenhoppers.block.ModBlocks;
import io.github.haykam821.woodenhoppers.block.entity.WoodenHopperBlockEntity;
import io.github.haykam821.woodenhoppers.screen.WoodenHopperScreenHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Main implements ModInitializer {
	public static final String MOD_ID = "woodenhoppers";

	private static final Identifier WOODEN_HOPPER_ID = new Identifier(MOD_ID, "wooden_hopper");
	public static final BlockEntityType<WoodenHopperBlockEntity> WOODEN_HOPPER_BLOCK_ENTITY_TYPE = FabricBlockEntityTypeBuilder
		.create(WoodenHopperBlockEntity::new, ModBlocks.OAK_HOPPER.getBlock(), ModBlocks.SPRUCE_HOPPER.getBlock(), ModBlocks.BIRCH_HOPPER.getBlock(), ModBlocks.JUNGLE_HOPPER.getBlock(), ModBlocks.ACACIA_HOPPER.getBlock(), ModBlocks.DARK_OAK_HOPPER.getBlock(), ModBlocks.CRIMSON_HOPPER.getBlock(), ModBlocks.WARPED_HOPPER.getBlock())
		.build(null);

	public static final ScreenHandlerType<WoodenHopperScreenHandler> WOODEN_HOPPER_SCREEN_HANDLER_TYPE = new ScreenHandlerType<>(WoodenHopperScreenHandler::new);

	@Override
	public void onInitialize() {
		ModBlocks.initialize();
		Registry.register(Registry.BLOCK_ENTITY_TYPE, WOODEN_HOPPER_ID, WOODEN_HOPPER_BLOCK_ENTITY_TYPE);

		Registry.register(Registry.SCREEN_HANDLER, WOODEN_HOPPER_ID, WOODEN_HOPPER_SCREEN_HANDLER_TYPE);
	}
}