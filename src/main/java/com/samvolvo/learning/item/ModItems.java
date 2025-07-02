package com.samvolvo.learning.item;

import com.samvolvo.learning.Learning;
import com.samvolvo.learning.item.custom.ChiselItem;
import com.samvolvo.learning.item.custom.HammerItem;
import com.samvolvo.learning.item.custom.ModArmorItem;
import com.samvolvo.learning.sound.ModSounds;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(Learning.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Learning.LOGGER.info("Registering mod Item for " + Learning.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.addAfter(Items.NETHERITE_INGOT ,PINK_GARNET);
            entries.addAfter(Items.ANCIENT_DEBRIS ,RAW_PINK_GARNET);
        });
    }

    private static Item.Settings itemSettingsWithKey(String name) {
        return new Item.Settings()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Learning.MOD_ID, name)));
    }

    /// Ores
    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(itemSettingsWithKey("pink_garnet")));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(itemSettingsWithKey("raw_pink_garnet")));

    ///  Tools
    public static final Item CHISEL = registerItem("chisel", new ChiselItem(itemSettingsWithKey("chisel").maxDamage(32)));

    /// Food
    public static final Item CAULIFLOWER = registerItem("cauliflower", new Item(itemSettingsWithKey("cauliflower").food(ModFoodComponents.CAULIFLOWER, ModFoodComponents.CAULIFLOWER_EFFECT)){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.learning.cauliflower"));

            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    /// Fuel
    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", new Item(itemSettingsWithKey("starlight_ashes")));

    /// Tools
    public static final Item PINK_GARNET_SWORD = registerItem("pink_garnet_sword",
            new SwordItem(ModToolMaterials.PINK_GARNET,3, -2.4f, itemSettingsWithKey("pink_garnet_sword")
            ));
    public static final Item PINK_GARNET_PICKAXE = registerItem("pink_garnet_pickaxe",
            new PickaxeItem(ModToolMaterials.PINK_GARNET,1, -2.8f, itemSettingsWithKey("pink_garnet_pickaxe")
            ));
    public static final Item PINK_GARNET_AXE = registerItem("pink_garnet_axe",
            new AxeItem(ModToolMaterials.PINK_GARNET,6, -3.2f, itemSettingsWithKey("pink_garnet_axe")
            ));
    public static final Item PINK_GARNET_HOE = registerItem("pink_garnet_hoe",
            new HoeItem(ModToolMaterials.PINK_GARNET, 0, -3f, itemSettingsWithKey("pink_garnet_hoe")
            ));
    public static final Item PINK_GARNET_SHOVEL = registerItem("pink_garnet_shovel",
            new ShovelItem(ModToolMaterials.PINK_GARNET, 1.5f, -3.0f, itemSettingsWithKey("pink_garnet_shovel")
            ));
    public static final Item PINK_GARNET_HAMMER = registerItem("pink_garnet_hammer",
            new HammerItem(ModToolMaterials.PINK_GARNET,7, -3.4f, itemSettingsWithKey("pink_garnet_hammer")
            ));
    
    /// Gear
    public static final Item KAUPEN_BOW = registerItem("kaupen_bow",
            new BowItem( itemSettingsWithKey("kaupen_bow").maxDamage(500)));

    /// Armor
    public static final Item PINK_GARNET_HELMET = registerItem("pink_garnet_helmet",
            new ModArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, EquipmentType.HELMET,
                    itemSettingsWithKey("pink_garnet_helmet")
                    ));

    public static final Item PINK_GARNET_CHESTPLATE = registerItem("pink_garnet_chestplate",
            new ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, EquipmentType.CHESTPLATE, itemSettingsWithKey("pink_garnet_chestplate")
                    ));

    public static final Item PINK_GARNET_LEGGINS = registerItem("pink_garnet_leggins",
            new ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, EquipmentType.LEGGINGS,
                    itemSettingsWithKey("pink_garnet_leggins")
                    ));

    public static final Item PINK_GARNET_BOOTS = registerItem("pink_garnet_boots",
            new ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, EquipmentType.BOOTS,
                    itemSettingsWithKey("pink_garnet_boots")
                    ));

    /// Horse armor
    public static final Item PINK_GARNET_HORSE_ARMOR = registerItem("pink_garnet_horse_armor",
            new AnimalArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, AnimalArmorItem.Type.EQUESTRIAN, itemSettingsWithKey("pink_garnet_horse_armor").maxCount(1))
    );

    /// Smitting templates
    public static final Item KAUPEN_SMITHING_TEMPLATE = registerItem("kaupen_armor_trim_smithing_template",
            SmithingTemplateItem.of(itemSettingsWithKey("kaupen_armor_trim_smithing_template")));


    /// Music Discs
    public static final Item I_AM_SAMVOLVO_MUSIC_DISK = registerItem("i_am_samvolvo_music_disc",
            new Item(itemSettingsWithKey("i_am_samvolvo_music_disc").jukeboxPlayable(ModSounds.I_AM_SAMVOLVO_KEY).maxCount(1)));
}
