package com.kaniwarytgames.custommod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public
class CustomMod implements ModInitializer {
    public static final String MOD_ID = "custommod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final Block CUSTOM_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool());
    public static final Item CUSTOM_ITEM = new Item(new FabricItemSettings().group(ItemGroup.MISC));

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Custom Mod");

        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "custom_ore"), CUSTOM_ORE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "custom_ore"), new BlockItem(CUSTOM_ORE, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "custom_item"), CUSTOM_ITEM);

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            CustomCommand.register(dispatcher);
        });
    }
}
