package com.samvolvo.learning.potion;

import com.samvolvo.learning.Learning;
import com.samvolvo.learning.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static void registerPotions(){
        Learning.LOGGER.info("Registering potions for " + Learning.MOD_ID);
    }

    private static RegistryEntry<Potion> registerPotion(String name, Potion potion){
        return Registry.registerReference(Registries.POTION, Identifier.of(Learning.MOD_ID, name), potion);
    }

    // Register potion
    public static final RegistryEntry<Potion> SLIMEY_POTION = registerPotion("slimey_potion",
            new Potion("slimey_potion",new StatusEffectInstance(ModEffects.SLIMEY, 1200, 0)));
}
