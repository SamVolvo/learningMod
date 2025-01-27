package com.samvolvo.learning.component;

import com.samvolvo.learning.Learning;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {
    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator){
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(Learning.MOD_ID, name),
                builderOperator.apply(ComponentType.builder()).build()
                );
    }

    public static void registerDataComponentTypes(){
        Learning.LOGGER.info("Registering Data Component Types for " + Learning.MOD_ID);
    }

    public static final ComponentType<BlockPos> COORDINATES = register("coordinates", builder -> builder.codec(BlockPos.CODEC));

}
