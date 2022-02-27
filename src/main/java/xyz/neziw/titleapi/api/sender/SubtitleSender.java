package xyz.neziw.titleapi.api.sender;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import xyz.neziw.titleapi.api.event.BroadcastSubtitleEvent;
import xyz.neziw.titleapi.api.event.DetailedSubtitleSendEvent;
import xyz.neziw.titleapi.api.event.SubtitleSendEvent;
import xyz.neziw.titleapi.util.ColorUtil;

public class SubtitleSender {

    /*---------------------------------------------------*/
    public static void sendSubTitle(@NotNull String message, @NotNull Player player) {
        SubtitleSendEvent subtitleSendEvent = new SubtitleSendEvent(player, message);
        Bukkit.getPluginManager().callEvent(subtitleSendEvent);
        if(subtitleSendEvent.isCancelled()) {
            return;
        }
        player.sendTitle(" ", ColorUtil.fixColors(message), 16, 24, 16);
        return;
    }
    /*---------------------------------------------------*/
    public static void sendSubTitle(@NotNull String message, int fadein, int stayin, int fadeout, @NotNull Player player) {
        DetailedSubtitleSendEvent detailedSubtitleSendEvent = new DetailedSubtitleSendEvent(player, message, fadein, stayin, fadeout);
        Bukkit.getPluginManager().callEvent(detailedSubtitleSendEvent);
        if(detailedSubtitleSendEvent.isCancelled()) {
            return;
        }
        player.sendTitle(" ", ColorUtil.fixColors(message), fadein, stayin, fadeout);
        return;
    }
    /*---------------------------------------------------*/
    public static void broadcastSubTitle(@NotNull String message) {
        BroadcastSubtitleEvent broadcastSubtitleEvent = new BroadcastSubtitleEvent(message);
        Bukkit.getPluginManager().callEvent(broadcastSubtitleEvent);
        if(broadcastSubtitleEvent.isCancelled()) {
            return;
        }
        for (Player players : Bukkit.getOnlinePlayers()) {
            players.sendTitle(" ", ColorUtil.fixColors(message), 16, 24, 16);
            return;
        }
        return;
    }
    /*---------------------------------------------------*/
}
