package net.devLua.createmotorsadditions.ModBlocks.entities;

import net.devLua.createmotorsadditions.ModBlocks.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class electric_motor_entity extends BlockEntity {


    public electric_motor_entity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.electric_motor_entity.get(), pos, blockState);
    }
}
