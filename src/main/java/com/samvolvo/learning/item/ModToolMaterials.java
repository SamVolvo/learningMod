package com.samvolvo.learning.item;

import com.google.common.base.Suppliers;
import com.samvolvo.learning.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;

import javax.tools.Tool;
import java.util.Objects;
import java.util.function.Supplier;

public class ModToolMaterials {
    public static final ToolMaterial PINK_GARNET = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_PINK_GARNET_TOOL, 1500, 7.0f,
            2.0f, 22, ModTags.Items.PINK_GARNET_REPAIR);
}
