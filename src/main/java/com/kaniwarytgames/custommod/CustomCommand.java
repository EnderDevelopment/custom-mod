package com.kaniwarytgames.custommod;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import static net.minecraft.server.command.CommandManager.literal;

public
class CustomCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("givecustomitem").executes(context -> {
            ServerPlayerEntity player = context.getSource().getPlayer();
            if (player != null) {
                player.giveItemStack(CustomMod.CUSTOM_ITEM.getDefaultStack());
                player.sendMessage(Text.literal("You have been given a custom item!"));
            }
            return 1;
        }));
    }
}
