package net.devLua.createmotorsadditions.ModItems;

import net.devLua.createmotorsadditions.CreateMotorsAndAdditions;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreateMotorsAndAdditions.MODID);


    public static final DeferredItem<Item> copperWire = ITEMS.register("copper_wire",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> spool = ITEMS.register("spool",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> copperSpool = ITEMS.register("copper_spool",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
