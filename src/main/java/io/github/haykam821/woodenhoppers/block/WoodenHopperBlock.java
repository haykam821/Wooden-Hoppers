package io.github.haykam821.woodenhoppers.block;

import io.github.haykam821.woodenhoppers.Main;
import io.github.haykam821.woodenhoppers.block.entity.WoodenHopperBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HopperBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.HopperBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WoodenHopperBlock extends HopperBlock {
	public WoodenHopperBlock(Block.Settings settings) {
		super(settings);
	}

	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new WoodenHopperBlockEntity(pos, state);
	}

	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
		return world.isClient() ? null : validateTicker(type, Main.WOODEN_HOPPER_BLOCK_ENTITY_TYPE, HopperBlockEntity::serverTick);
	}
}