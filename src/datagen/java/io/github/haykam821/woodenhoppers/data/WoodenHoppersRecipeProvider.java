package io.github.haykam821.woodenhoppers.data;

import java.util.Objects;

import io.github.haykam821.woodenhoppers.Main;
import io.github.haykam821.woodenhoppers.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementRequirements.CriterionMerger;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RawShapedRecipe;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

public class WoodenHoppersRecipeProvider extends FabricRecipeProvider {
	private static final Identifier GROUP_ID = new Identifier(Main.MOD_ID, "wooden_hopper");
	private static final String GROUP = GROUP_ID.toString();

	public WoodenHoppersRecipeProvider(FabricDataOutput dataOutput) {
		super(dataOutput);
	}

	@Override
	public void generate(RecipeExporter exporter) {
		for (ModBlocks modBlock : ModBlocks.values()) {
			WoodenHoppersRecipeProvider.offerWoodenHopperRecipe(exporter, modBlock.getBlock(), modBlock.getBase());
		}
	}

	public static void offerWoodenHopperRecipe(RecipeExporter exporter, Block block, Block base) {
		ShapedRecipeJsonBuilder builder = ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, block)
			.input('#', Ingredient.ofItems(base))
			.input('C', Items.CHEST)
			.pattern("# #")
			.pattern("#C#")
			.pattern(" # ")
			.group(GROUP)
			.criterion(RecipeProvider.hasItem(base), RecipeProvider.conditionsFromItem(base));

		WoodenHoppersRecipeProvider.offerCraftingTo(exporter, builder);
	}

	private static void offerCraftingTo(RecipeExporter exporter, ShapedRecipeJsonBuilder factory) {
		Identifier recipeId = CraftingRecipeJsonBuilder.getItemId(factory.getOutputItem());
		WoodenHoppersRecipeProvider.offerShapedTo(exporter, recipeId, factory);
	}

	private static void offerShapedTo(RecipeExporter exporter, Identifier recipeId, ShapedRecipeJsonBuilder factory) {
		RawShapedRecipe rawRecipe = factory.validate(recipeId);

		Identifier advancementId = WoodenHoppersRecipeProvider.getAdvancementId(recipeId);
		AdvancementEntry advancement = exporter.getAdvancementBuilder()
			.criterion("has_the_recipe", RecipeUnlockedCriterion.create(recipeId))
			.rewards(AdvancementRewards.Builder.recipe(recipeId))
			.criteriaMerger(CriterionMerger.OR)
			.build(advancementId);

		String group = Objects.requireNonNullElse(factory.group, "");
		CraftingRecipeCategory category = CraftingRecipeJsonBuilder.toCraftingCategory(factory.category);

		ShapedRecipe recipe = new ShapedRecipe(group, category, rawRecipe, new ItemStack(factory.getOutputItem(), factory.count), factory.showNotification);
		exporter.accept(recipeId, recipe, advancement);
	}

	private static Identifier getAdvancementId(Identifier recipeId) {
		return new Identifier(recipeId.getNamespace(), "recipes/" + recipeId.getPath());
	}
}
