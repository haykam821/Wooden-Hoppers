package io.github.haykam821.woodenhoppers.screen;

import com.mojang.blaze3d.systems.RenderSystem;

import io.github.haykam821.woodenhoppers.Main;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class WoodenHopperScreen extends HandledScreen<WoodenHopperScreenHandler> {
	private static final Identifier TEXTURE = new Identifier(Main.MOD_ID, "textures/gui/container/wooden_hopper.png");

	public WoodenHopperScreen(WoodenHopperScreenHandler handler, PlayerInventory inventory, Text title) {
      super(handler, inventory, title);
	  this.passEvents = false;

      this.backgroundHeight = 133;
      this.playerInventoryTitleY = this.backgroundHeight - 94;
   }

	public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
		this.renderBackground(matrices);
		super.render(matrices, mouseX, mouseY, delta);

		this.drawMouseoverTooltip(matrices, mouseX, mouseY);
	}

	protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
		RenderSystem.color4f(1, 1, 1, 1);
		this.client.getTextureManager().bindTexture(TEXTURE);

		int x = (this.width - this.backgroundWidth) / 2;
		int y = (this.height - this.backgroundHeight) / 2;

		this.drawTexture(matrices, x, y, 0, 0, this.backgroundWidth, this.backgroundHeight);
	}
}