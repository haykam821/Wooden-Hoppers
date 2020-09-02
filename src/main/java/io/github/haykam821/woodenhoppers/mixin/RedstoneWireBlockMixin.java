package io.github.haykam821.woodenhoppers.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.haykam821.woodenhoppers.block.WoodenHopperBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneWireBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

@Mixin(RedstoneWireBlock.class)
public class RedstoneWireBlockMixin {
	@Inject(method = "canRunOnTop", at = @At("HEAD"), cancellable = true)
	private void allowWireOnWoodenHoppers(BlockView world, BlockPos pos, BlockState floor, CallbackInfoReturnable<Boolean> ci) {
		if (floor.getBlock() instanceof WoodenHopperBlock) {
			ci.setReturnValue(true);
		}
	}
}