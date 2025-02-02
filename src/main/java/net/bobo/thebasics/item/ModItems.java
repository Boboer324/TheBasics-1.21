package net.bobo.thebasics.item;

import net.bobo.thebasics.TheBasics;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item REMAINS = registerItem("remains",new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TheBasics.MOD_ID,"remains")))));
    public static final Item RAW_REMAINS = registerItem("raw_remains", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TheBasics.MOD_ID,"raw_remains")))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TheBasics.MOD_ID, name), item);
    }

    public static void registerModItems(){
        TheBasics.LOGGER.info("Registering Mod Items" + TheBasics.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(REMAINS);
            entries.add(RAW_REMAINS);
        });
    }
}