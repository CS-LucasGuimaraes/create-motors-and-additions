package net.devLua.createmotorsadditions.ModBlocks.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.antlr.v4.runtime.atn.BlockStartState;

import javax.annotation.Nullable;

public class electric_motor extends BaseEntityBlock {
    public static final MapCodec<electric_motor> CODEC = simpleCodec(electric_motor::new);
    public static final DirectionProperty FACING = DirectionalBlock.FACING;

    public static final VoxelShape[] SHAPES = new VoxelShape[]{
            Shapes.or(Block.box(3.0, 2.0, 3.0, 13.0, 16.0, 13.0),Block.box(0.0, 5.0, 0.0, 16.0, 11.0, 16.0)), // DOWN
            Shapes.or(Block.box(3.0, 0.0, 3.0, 13.0, 14.0, 13.0),Block.box(0.0, 5.0, 0.0, 16.0, 11.0, 16.0)), // UP
            Shapes.or(Block.box(3.0, 3.0, 2.0, 13.0, 13.0, 16.0),Block.box(0.0, 0.0, 5.0, 16.0, 16.0, 11.0)), // NORTH
            Shapes.or(Block.box(3.0, 3.0, 0.0, 13.0, 13.0, 14.0),Block.box(0.0, 0.0, 5.0, 16.0, 16.0, 11.0)), // SOUTH
            Shapes.or(Block.box(2.0, 3.0, 3.0, 16.0, 13.0, 13.0),Block.box(5.0, 0.0, 0.0, 11.0, 16.0, 16.0)), // WEST
            Shapes.or(Block.box(0.0, 3.0, 3.0, 14.0, 13.0, 13.0),Block.box(5.0, 0.0, 0.0, 11.0, 16.0, 16.0)), // EAST
    };

    public electric_motor(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPES[state.getValue(FACING).ordinal()];
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        if(context.getPlayer().isSteppingCarefully())
            return this.defaultBlockState().setValue(FACING, context.getNearestLookingDirection().getOpposite());
        return this.defaultBlockState().setValue(FACING, context.getNearestLookingDirection());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

//    @Override
//    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos,
//                                               Player player, BlockHitResult hit) {
//
//        level.playSound(player, pos, SoundEvents.AMETHYST_CLUSTER_HIT, SoundSource.BLOCKS, 1.0f, 1.0f);
//
//        return InteractionResult.SUCCESS;
//    }

    /* Block Entity */

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return null;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos,
                                               Player player, BlockHitResult hit) {



        return InteractionResult.SUCCESS;
    }
}
