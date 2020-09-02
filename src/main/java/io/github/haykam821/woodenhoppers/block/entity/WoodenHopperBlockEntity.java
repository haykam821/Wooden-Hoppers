package io.github.haykam821.woodenhoppers.block.entity;

import io.github.haykam821.woodenhoppers.Main;
import io.github.haykam821.woodenhoppers.screen.WoodenHopperScreenHandler;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.HopperBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class WoodenHopperBlockEntity extends HopperBlockEntity {
	@Override
	public Text getContainerName() {
		return new TranslatableText("container.wooden_hopper");
	}

	@Override
	public BlockEntityType<?> getType() {
		return Main.WOODEN_HOPPER_BLOCK_ENTITY_TYPE;
	}

	@Override
	protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
		return new WoodenHopperScreenHandler(syncId, playerInventory, this);
	}
}