package xyz.neziw.titleapi.api.sender;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;
import xyz.neziw.titleapi.api.event.ActionbarSendEvent;
import xyz.neziw.titleapi.api.event.BroadcastActionbarEvent;
import xyz.neziw.titleapi.api.event.TimedActionbarSendEvent;
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
    public static void sendActionBar(@NotNull String message, int duration, @NotNull Player player, @NotNull Plugin plugin) {
        TimedActionbarSendEvent timedActionbarSendEvent = new TimedActionbarSendEvent(player, message, duration);
        Bukkit.getPluginManager().callEvent(timedActionbarSendEvent);
        if(timedActionbarSendEvent.isCancelled()) {
            return;
        }
        if(duration >= 0) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    sendActionBar(" ", player);
                }
            }.runTaskLater(plugin, (long) duration);
        }
        while (duration > 40) {
            duration -= 40;
            new BukkitRunnable() {
                @Override
                public void run() {
                    sendActionBar(message, player);
                }
            }.runTaskLater(plugin, (long) duration);
        }
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
