package io.github.haykam821.woodenhoppers.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;

import io.github.haykam821.woodenhoppers.block.entity.WoodenHopperBlockEntity;
import net.minecraft.block.entity.HopperBlockEntity;

@Mixin(HopperBlockEntity.class)
public abstract class HopperBlockEntityMixin {
	@Shadow
	public abstract void setCooldown(int cooldown);

	@Unique
	private int getCooldown(int initialValue) {
		if ((Object) this instanceof WoodenHopperBlockEntity) {
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
	private int modifyLongerInsertAndExtractCooldown(int initialValue) {
		return this.getCooldown(initialValue);
	}

	@Redirect(method = "transfer(Lnet/minecraft/inventory/Inventory;Lnet/minecraft/inventory/Inventory;Lnet/minecraft/item/ItemStack;ILnet/minecraft/util/math/Direction;)Lnet/minecraft/item/ItemStack;", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/entity/HopperBlockEntity;setCooldown(I)V"))
	private static void setLongerTransferCooldown(HopperBlockEntity blockEntity, int cooldown) {
		((HopperBlockEntityMixin) (Object) blockEntity).setCooldown(cooldown + (blockEntity instanceof WoodenHopperBlockEntity ? 4 : 0));
	}

	@ModifyConstant(method = "isDisabled", constant = @Constant(intValue = 8))
	private int modifyLongerDisabledCooldown(int initialValue) {
		return this.getCooldown(initialValue);
	}
}