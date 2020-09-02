package io.github.haykam821.woodenhoppers;

import io.github.haykam821.woodenhoppers.screen.WoodenHopperScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

public class ClientMain implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ScreenRegistry.register(Main.WOODEN_HOPPER_SCREEN_HANDLER_TYPE, WoodenHopperScreen::new);
	}
}