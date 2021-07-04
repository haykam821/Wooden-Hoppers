package io.github.haykam821.woodenhoppers.mixin;

import java.util.Map;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.haykam821.woodenhoppers.Main;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

@Mixin(AbstractFurnaceBlockEntity.class)
public class AbstractFurnaceBlockEntityMixin {
	@Unique
	private static final int WOODEN_HOPPER_FUEL_TIME = 15 * 20;

	@Unique
	private static final Identifier WOODEN_HOPPERS_ID = new Identifier(Main.MOD_ID, "wooden_hoppers");

	@Unique
	private static final Tag<Item> WOODEN_HOPPERS_ITEM_TAG = TagRegistry.item(WOODEN_HOPPERS_ID);

	@Shadow
	private static void addFuel(Map<Item, Integer> fuelTimes, Tag<Item> tag, int fuelTime) {
		throw new IllegalStateException();
	}

	@Inject(method = "createFuelTimeMap", at = @At("RETURN"))
	private static void addWoodenHoppersToFuelTimeMap(CallbackInfoReturnable<Map<Item, Integer>> ci) {
		addFuel(ci.getReturnValue(), WOODEN_HOPPERS_ITEM_TAG, WOODEN_HOPPER_FUEL_TIME);
	}
}