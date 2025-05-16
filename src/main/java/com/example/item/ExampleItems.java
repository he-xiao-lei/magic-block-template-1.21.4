package com.example.item;

import com.example.MagicBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ExampleItems {
    This is a Example Setences.
    private ExampleItems(){

    }
    public static final Item CUSTOM_ITEM = register("magic_block", Item::new, new Item.Settings().maxCount(100));

    public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MagicBlock.MOD_ID.replace('-','_'), path));
        return Items.register(registryKey, factory, settings);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(CUSTOM_ITEM));
        FuelRegistryEvents.BUILD.register(((builder, context) -> builder.add(CUSTOM_ITEM,30*1000)));
    }
}
