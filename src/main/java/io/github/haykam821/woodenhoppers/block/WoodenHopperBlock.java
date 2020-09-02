package io.github.haykam821.woodenhoppers.block;

import io.github.haykam821.woodenhoppers.block.entity.WoodenHopperBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.HopperBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;

public class WoodenHopperBlock extends HopperBlock {
	public WoodenHopperBlock(Block.Settings settings) {
		super(settings);
	}

	@Override
	public BlockEntity createBlockEntity(BlockView world) {
		return new WoodenHopperBlockEntity();
	}
}