package xyz.neziw.titleapi.api.sender;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import xyz.neziw.titleapi.api.event.ActionbarSendEvent;
import xyz.neziw.titleapi.api.event.BroadcastActionbarEvent;
import xyz.neziw.titleapi.util.ColorUtil;

public class ActionbarSender {

    /*---------------------------------------------------*/
    public static void sendActionBar(@NotNull String message, @NotNull Player player) {
        ActionbarSendEvent actionbarSendEvent = new ActionbarSendEvent(player, message);
        Bukkit.getPluginManager().callEvent(actionbarSendEvent);
        if(actionbarSendEvent.isCancelled()) {
            return;
        }
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ColorUtil.fixColors(message)));
        return;
    }
    /*---------------------------------------------------*/
    public static void broadcastActionBar(@NotNull String message) {
        BroadcastActionbarEvent broadcastActionbarEvent = new BroadcastActionbarEvent(message);
        Bukkit.getPluginManager().callEvent(broadcastActionbarEvent);
        if(broadcastActionbarEvent.isCancelled()) {
            return;
        }
        for (Player players : Bukkit.getOnlinePlayers()) {
            players.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ColorUtil.fixColors(message)));
            return;
        }
        return;
    }
    /*---------------------------------------------------*/
}
