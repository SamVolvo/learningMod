package com.samvolvo.learning.sound;

import com.samvolvo.learning.Learning;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent CHISEL_USE = registerSoundEvent("chisel_use");

    public static final SoundEvent MAGIC_BLOCK_BREAK = registerSoundEvent("magic_block_break");
    public static final SoundEvent MAGIC_BLOCK_STEP = registerSoundEvent("magic_block_step");
    public static final SoundEvent MAGIC_BLOCK_PLACE = registerSoundEvent("magic_block_place");
    public static final SoundEvent MAGIC_BLOCK_HIT = registerSoundEvent("magic_block_hit");
    public static final SoundEvent MAGIC_BLOCK_FALL = registerSoundEvent("magic_block_fall");

    public static final BlockSoundGroup MAGIC_BLOCK_SOUNDS = new BlockSoundGroup(1f, 1f,
            MAGIC_BLOCK_BREAK, MAGIC_BLOCK_STEP, MAGIC_BLOCK_PLACE, MAGIC_BLOCK_HIT, MAGIC_BLOCK_FALL
            );

    public static final SoundEvent I_AM_SAMVOLVO = registerSoundEvent("i_am_samvolvo");
    public static final RegistryKey<JukeboxSong> I_AM_SAMVOLVO_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Learning.MOD_ID, "i_am_samvolvo"));

    private static SoundEvent registerSoundEvent(String name){
        Identifier id = Identifier.of(Learning.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds(){
        Learning.LOGGER.info("Registering Mod Sounds for " + Learning.MOD_ID);
    }
}
