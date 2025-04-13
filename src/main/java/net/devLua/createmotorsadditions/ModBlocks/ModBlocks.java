package net.devLua.createmotorsadditions.ModBlocks;

import net.devLua.createmotorsadditions.CreateMotorsAndAdditions;
import net.devLua.createmotorsadditions.ModBlocks.custom.electric_motor;
import net.devLua.createmotorsadditions.ModItems.ModItems;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CreateMotorsAndAdditions.MODID);

    public static final DeferredBlock<Block> electricMotor = registerBlock("electric_motor",
            () -> new electric_motor(BlockBehaviour.Properties.of()
                    .noOcclusion()
                    .strength(4F)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)
                    ));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
