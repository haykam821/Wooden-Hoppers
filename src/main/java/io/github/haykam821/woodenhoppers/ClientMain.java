package io.github.haykam821.woodenhoppers;

import io.github.haykam821.woodenhoppers.screen.WoodenHopperScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class ClientMain implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		HandledScreens.register(Main.WOODEN_HOPPER_SCREEN_HANDLER_TYPE, WoodenHopperScreen::new);
	}
}