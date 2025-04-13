package net.devLua.createmotorsadditions.ModBlocks.entities;

import net.devLua.createmotorsadditions.CreateMotorsAndAdditions;
import net.devLua.createmotorsadditions.ModBlocks.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, CreateMotorsAndAdditions.MODID);

    public static final Supplier<BlockEntityType<electric_motor_entity>> electric_motor_entity =
            BLOCK_ENTITIES.register("electric_motor_entity", () -> BlockEntityType.Builder.of(
                    electric_motor_entity::new, ModBlocks.electricMotor.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
