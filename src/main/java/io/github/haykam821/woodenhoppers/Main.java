package io.github.haykam821.woodenhoppers;

import io.github.haykam821.woodenhoppers.block.ModBlocks;
import io.github.haykam821.woodenhoppers.block.entity.WoodenHopperBlockEntity;
import io.github.haykam821.woodenhoppers.screen.WoodenHopperScreenHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Main implements ModInitializer {
	public static final String MOD_ID = "woodenhoppers";

	private static final Identifier WOODEN_HOPPER_ID = new Identifier(MOD_ID, "wooden_hopper");

	public static final BlockEntityType<WoodenHopperBlockEntity> WOODEN_HOPPER_BLOCK_ENTITY_TYPE = BlockEntityType.Builder
		.create(
			WoodenHopperBlockEntity::new,
			ModBlocks.getBlocks()
		)
		.build(null);

	public static final ScreenHandlerType<WoodenHopperScreenHandler> WOODEN_HOPPER_SCREEN_HANDLER_TYPE = ScreenHandlerRegistry.registerSimple(WOODEN_HOPPER_ID, WoodenHopperScreenHandler::new);

	@Override
	public void onInitialize() {
		ModBlocks.initialize();
		Registry.register(Registry.BLOCK_ENTITY_TYPE, WOODEN_HOPPER_ID, WOODEN_HOPPER_BLOCK_ENTITY_TYPE);
	}
}