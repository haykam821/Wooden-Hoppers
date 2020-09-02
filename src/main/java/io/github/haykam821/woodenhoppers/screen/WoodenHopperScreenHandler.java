package io.github.haykam821.woodenhoppers.screen;

import io.github.haykam821.woodenhoppers.Main;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class WoodenHopperScreenHandler extends ScreenHandler {
	private final Inventory inventory;

	public WoodenHopperScreenHandler(int syncId, PlayerInventory playerInventory) {
		this(syncId, playerInventory, new SimpleInventory(1));
	}

	public WoodenHopperScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
		super(Main.WOODEN_HOPPER_SCREEN_HANDLER_TYPE, syncId);

		this.inventory = inventory;
		checkSize(inventory, 1);

		inventory.onOpen(playerInventory.player);

		this.addSlot(new Slot(inventory, 0, 80, 20));

		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 9; column++) {
				this.addSlot(new Slot(playerInventory, column + row * 9 + 9, column * 18 + 8, row * 18 + 51));
			}
		}

		for(int column = 0; column < 9; column++) {
			this.addSlot(new Slot(playerInventory, column, column * 18 + 8, 109));
		}
	}

	@Override
	public boolean canUse(PlayerEntity player) {
		return this.inventory.canPlayerUse(player);
	}

	@Override
	public ItemStack transferSlot(PlayerEntity player, int index) {
		Slot slot = this.slots.get(index);
		if (slot == null || !slot.hasStack()) return ItemStack.EMPTY;
	
		ItemStack slotStack = slot.getStack();
		ItemStack stack = slotStack.copy();

		if (index == 0) {
			if (!this.insertItem(slotStack, this.inventory.size(), this.slots.size(), true)) {
				return ItemStack.EMPTY;
			}
		} else if (!this.insertItem(slotStack, 0, this.inventory.size(), false)) {
			return ItemStack.EMPTY;
		}

		if (slotStack.isEmpty()) {
			slot.setStack(ItemStack.EMPTY);
		} else {
			slot.markDirty();
		}

		return stack;
	}

	@Override
	public void close(PlayerEntity player) {
		super.close(player);
		this.inventory.onClose(player);
	}
}