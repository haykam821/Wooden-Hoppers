package io.github.haykam821.woodenhoppers.tag;

import io.github.haykam821.woodenhoppers.Main;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.RegistryKeys;

public final class WoodenHoppersBlockTags {
	public static final TagKey<Block> WOODEN_HOPPERS = WoodenHoppersBlockTags.of("wooden_hoppers");

	private WoodenHoppersBlockTags() {
		return;
	}

	private static TagKey<Block> of(String path) {
		Identifier id = new Identifier(Main.MOD_ID, path);
		return TagKey.of(RegistryKeys.BLOCK, id);
	}
}
