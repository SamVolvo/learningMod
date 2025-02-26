package com.samvolvo.learning;

import com.samvolvo.learning.block.ModBlocks;
import com.samvolvo.learning.component.ModDataComponentTypes;
import com.samvolvo.learning.item.ModItemGroups;
import com.samvolvo.learning.item.ModItems;
import com.samvolvo.learning.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
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

		initializeFuel();
		registerEvents();
	}

	/// Register all fuel
	private void initializeFuel(){
		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 16000);
	}

	private void registerEvents(){
		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
	}
}