package io.github.haykam821.woodenhoppers.block.entity;

import io.github.haykam821.woodenhoppers.Main;
import io.github.haykam821.woodenhoppers.screen.WoodenHopperScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.HopperBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class WoodenHopperBlockEntity extends HopperBlockEntity {
	public WoodenHopperBlockEntity(BlockPos pos, BlockState state) {
		super(pos, state);
	}

	@Override
	public Text getContainerName() {
		return Text.translatable("container.wooden_hopper");
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