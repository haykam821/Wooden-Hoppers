package io.github.haykam821.woodenhoppers.mixin;

import java.util.Map;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.haykam821.woodenhoppers.tag.WoodenHoppersItemTags;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;

@Mixin(AbstractFurnaceBlockEntity.class)
public class AbstractFurnaceBlockEntityMixin {
	@Unique
	private static final int WOODEN_HOPPER_FUEL_TIME = 15 * 20;

	@Shadow
	private static void addFuel(Map<Item, Integer> fuelTimes, TagKey<Item> tag, int fuelTime) {
		throw new IllegalStateException();
	}

	@Inject(method = "createFuelTimeMap", at = @At("RETURN"))
	private static void addWoodenHoppersToFuelTimeMap(CallbackInfoReturnable<Map<Item, Integer>> ci) {
		addFuel(ci.getReturnValue(), WoodenHoppersItemTags.WOODEN_HOPPERS, WOODEN_HOPPER_FUEL_TIME);
	}
}