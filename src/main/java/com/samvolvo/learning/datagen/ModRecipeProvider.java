package com.samvolvo.learning.datagen;

import com.samvolvo.learning.Learning;
import com.samvolvo.learning.block.ModBlocks;
import com.samvolvo.learning.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeGenerator;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                List<ItemConvertible> PINK_GARNET_SMELTABLES = List.of(ModItems.RAW_PINK_GARNET, ModBlocks.PINK_GARNET_ORE,
                        ModBlocks.PINK_GARNET_DEEPSLATE_ORE);

                // Smelting, Pink Garnet
                offerSmelting(PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 200, "pink_garnet");
                offerBlasting(PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 200, "pink_garnet");

                // Pink Garnet or Pink Garnet Block Bothways automatic.
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_GARNET, RecipeCategory.DECORATIONS, ModBlocks.PINK_GARNET_BLOCK);

                // Raw pink Garnet Block
                createShaped(RecipeCategory.MISC, ModBlocks.RAW_PINK_GARNET_BLOCK)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .input('R', ModItems.RAW_PINK_GARNET)
                        .criterion(hasItem(ModItems.RAW_PINK_GARNET), conditionsFromItem(ModItems.RAW_PINK_GARNET))
                        .offerTo(recipeExporter);
                ;

                // Raw Pink Garnet from Raw Pink Garnet Block
                createShapeless(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 9)
                        .input(ModBlocks.RAW_PINK_GARNET_BLOCK)
                        .criterion(hasItem(ModBlocks.RAW_PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.RAW_PINK_GARNET_BLOCK))
                        .offerTo(recipeExporter);
                ;

                // Pink Garnet
                createShapeless(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 32)
                        .input(ModBlocks.MAGIC_BLOCK)
                        .criterion(hasItem(ModBlocks.MAGIC_BLOCK), conditionsFromItem(ModBlocks.MAGIC_BLOCK))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(Learning.MOD_ID, "raw_pink_garnet_from_magic_block")));
                ;

                // Pink Garnet Sword
                createShaped(RecipeCategory.COMBAT, ModItems.PINK_GARNET_SWORD)
                        .pattern(" P ")
                        .pattern(" P ")
                        .pattern(" S ")
                        .input('P', ModItems.PINK_GARNET)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                        .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                        .offerTo(recipeExporter);
                ;

                // Pink garnet Pickaxe
                createShaped(RecipeCategory.TOOLS, ModItems.PINK_GARNET_PICKAXE)
                        .pattern("PPP")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('P', ModItems.PINK_GARNET)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                        .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                        .offerTo(recipeExporter);
                ;

                // Pink garnet Axe
                createShaped(RecipeCategory.TOOLS, ModItems.PINK_GARNET_AXE)
                        .pattern("PP ")
                        .pattern("PS ")
                        .pattern(" S ")
                        .input('P', ModItems.PINK_GARNET)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                        .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                        .offerTo(recipeExporter);
                ;

                // Pink garnet Shovel
                createShaped(RecipeCategory.TOOLS, ModItems.PINK_GARNET_SHOVEL)
                        .pattern(" P ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('P', ModItems.PINK_GARNET)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                        .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                        .offerTo(recipeExporter);
                ;

                // Pink garnet Hoe
                createShaped(RecipeCategory.TOOLS, ModItems.PINK_GARNET_HOE)
                        .pattern("PP ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('P', ModItems.PINK_GARNET)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                        .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                        .offerTo(recipeExporter);
                ;

                // Pink Garnet Hammer
                createShaped(RecipeCategory.TOOLS, ModItems.PINK_GARNET_HAMMER)
                        .pattern("PPP")
                        .pattern("PSP")
                        .pattern(" S ")
                        .input('P', ModItems.PINK_GARNET)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                        .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                        .offerTo(recipeExporter);
                ;

                // Trim patterns
                offerSmithingTrimRecipe(ModItems.KAUPEN_SMITHING_TEMPLATE, RegistryKey.of(RegistryKeys.RECIPE,
                        Identifier.ofVanilla(getItemPath(ModItems.KAUPEN_SMITHING_TEMPLATE) + "_smithing_trim")));
            }
        };
    }

    @Override
    public String getName() {
        return "Learning Recipes";
    }
}
