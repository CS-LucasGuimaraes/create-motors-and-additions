package net.devLua.createmotorsadditions;

import net.devLua.createmotorsadditions.ModBlocks.ModBlocks;
import net.devLua.createmotorsadditions.ModItems.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateMotorsAndAdditions.MODID);

    public static final Supplier<CreativeModeTab> CreateMotorsAndAdditions_TAB = CREATIVE_MODE_TAB.register("create_motors_and_additions_tab",
            () -> CreativeModeTab.builder()
                    .icon( () -> new ItemStack(ModBlocks.electricMotor.get()) )
                    .title(Component.translatable("creativetab.createmotorsadditions.main"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.copperWire);
                        output.accept(ModItems.spool);
                        output.accept(ModItems.copperSpool);

                        output.accept(ModBlocks.electricMotor);
                    })

                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
