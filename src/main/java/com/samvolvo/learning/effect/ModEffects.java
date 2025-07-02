package com.samvolvo.learning.effect;

import com.samvolvo.learning.Learning;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static void registerEffects(){
        Learning.LOGGER.info("Registering Mod Effects for " + Learning.MOD_ID);
    }

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect){
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Learning.MOD_ID, name), statusEffect);
    }

    public static final RegistryEntry<StatusEffect> SLIMEY = registerStatusEffect("slimey",
            new SlimeyEffect(StatusEffectCategory.NEUTRAL, 0x36ebab)
                    .addAttributeModifier(EntityAttributes.MOVEMENT_SPEED, Identifier.of(Learning.MOD_ID, "slimey"), -0.25f,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
            );
}
