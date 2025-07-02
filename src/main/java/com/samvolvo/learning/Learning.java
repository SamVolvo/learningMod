package com.samvolvo.learning;

import com.samvolvo.learning.block.ModBlocks;
import com.samvolvo.learning.component.ModDataComponentTypes;
import com.samvolvo.learning.effect.ModEffects;
import com.samvolvo.learning.item.ModItemGroups;
import com.samvolvo.learning.item.ModItems;
import com.samvolvo.learning.potion.ModPotions;
import com.samvolvo.learning.sound.ModSounds;
import com.samvolvo.learning.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Learning implements ModInitializer {
	public static final String MOD_ID = "learning";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Loading Mod!");
		ModItemGroups.registerItemGroups();

		ModDataComponentTypes.registerDataComponentTypes();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModSounds.registerSounds();
		ModEffects.registerEffects();
		ModPotions.registerPotions();

		initializeFuel();
		registerEvents();

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, Items.SLIME_BALL, ModPotions.SLIMEY_POTION);
		});
	}

	/// Register all fuel
	private void initializeFuel(){
		FuelRegistryEvents.BUILD.register(((builder, context) -> {
			builder.add(ModItems.STARLIGHT_ASHES, 600);
		}));
	}

	private void registerEvents(){
		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
		AttackEntityCallback.EVENT.register(((playerEntity, world, hand, entity, hitResult) -> {
			if (entity instanceof SheepEntity sheepEntity && !world.isClient){
				if (playerEntity.getMainHandStack().getItem() == Items.END_ROD){
					playerEntity.sendMessage(Text.literal("The player just hit a sheep with an END ROD! You sick freak"), false);
					playerEntity.getMainHandStack().decrement(1);
					sheepEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 600, 6));
				}
				return ActionResult.PASS;
			}

			return ActionResult.PASS;
		}));
	}
}