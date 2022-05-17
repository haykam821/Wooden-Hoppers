package io.github.haykam821.woodenhoppers.mixin;

import java.util.function.BooleanSupplier;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;

import io.github.haykam821.woodenhoppers.block.entity.WoodenHopperBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.HopperBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(HopperBlockEntity.class)
public abstract class HopperBlockEntityMixin {
	@Shadow
	public abstract void setTransferCooldown(int cooldown);

	@Unique
	private static int getCooldown(int initialValue, HopperBlockEntity blockEntity) {
		if (blockEntity instanceof WoodenHopperBlockEntity) {
			return 12;
		}
		return initialValue;
	}

	@ModifyConstant(method = "<init>", constant = @Constant(intValue = 5))
	private int modifyInventorySize(int initialValue) {
		if ((Object) this instanceof WoodenHopperBlockEntity) {
			return 1;
		}
		return initialValue;
	}

	@ModifyConstant(method = "insertAndExtract", constant = @Constant(intValue = 8))
	private static int modifyLongerInsertAndExtractCooldown(int initialValue, World world, BlockPos pos, BlockState state, HopperBlockEntity blockEntity, BooleanSupplier booleanSupplier) {
		return HopperBlockEntityMixin.getCooldown(initialValue, blockEntity);
	}

	@Redirect(method = "transfer(Lnet/minecraft/inventory/Inventory;Lnet/minecraft/inventory/Inventory;Lnet/minecraft/item/ItemStack;ILnet/minecraft/util/math/Direction;)Lnet/minecraft/item/ItemStack;", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/entity/HopperBlockEntity;setTransferCooldown(I)V"))
	private static void setLongerTransferCooldown(HopperBlockEntity blockEntity, int cooldown) {
		((HopperBlockEntityMixin) (Object) blockEntity).setTransferCooldown(cooldown + (blockEntity instanceof WoodenHopperBlockEntity ? 4 : 0));
	}

	@ModifyConstant(method = "isDisabled", constant = @Constant(intValue = 8))
	private int modifyLongerDisabledCooldown(int initialValue) {
		return HopperBlockEntityMixin.getCooldown(initialValue, (HopperBlockEntity) (Object) this);
	}
}