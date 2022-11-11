package io.github.haykam821.woodenhoppers.tag;

import io.github.haykam821.woodenhoppers.Main;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.RegistryKeys;

public final class WoodenHoppersItemTags {
	public static final TagKey<Item> WOODEN_HOPPERS = WoodenHoppersItemTags.of("wooden_hoppers");

	private WoodenHoppersItemTags() {
		return;
	}

	private static TagKey<Item> of(String path) {
		Identifier id = new Identifier(Main.MOD_ID, path);
		return TagKey.of(RegistryKeys.ITEM, id);
	}
}
