package xyz.neziw.titleapi.api.sender;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import xyz.neziw.titleapi.api.event.BroadcastTitleEvent;
import xyz.neziw.titleapi.api.event.DetailedTitleSendEvent;
import xyz.neziw.titleapi.api.event.MultiTitleSendEvent;
import xyz.neziw.titleapi.api.event.TitleSendEvent;
import xyz.neziw.titleapi.util.ColorUtil;

public class TitleSender {

    /*---------------------------------------------------*/
    public static void sendTitle(@NotNull String message, @NotNull Player player) {
        TitleSendEvent titleSendEvent = new TitleSendEvent(player, message);
        if(titleSendEvent.isCancelled()) {
            return;
        }
        player.sendTitle(ColorUtil.fixColors(message), " ", 16, 24, 16);
        return;
    }
    /*---------------------------------------------------*/
    public static void sendTitle(@NotNull String title, @NotNull String subtitle, @NotNull Player player) {
        MultiTitleSendEvent multiTitleSendEvent = new MultiTitleSendEvent(player, title, subtitle);
        if(multiTitleSendEvent.isCancelled()) {
            return;
        }
        player.sendTitle(ColorUtil.fixColors(title), ColorUtil.fixColors(subtitle), 16, 24, 16);
        return;
    }
    /*---------------------------------------------------*/
    public static void sendTitle(@NotNull String title, @NotNull String subtitle, int fadein, int stayin, int fadeout, @NotNull Player player) {
        DetailedTitleSendEvent detailedTitleSendEvent = new DetailedTitleSendEvent(player, title, subtitle, fadein, stayin, fadeout);
        if(detailedTitleSendEvent.isCancelled()) {
            return;
        }
        player.sendTitle(ColorUtil.fixColors(title), ColorUtil.fixColors(subtitle), fadein, stayin, fadeout);
        return;
    }
    /*---------------------------------------------------*/
    public static void broadcastTitle(@NotNull String message, @NotNull Player player) {
        BroadcastTitleEvent broadcastTitleEvent = new BroadcastTitleEvent(player, message);
        if(broadcastTitleEvent.isCancelled()) {
            return;
        }
        for (Player players : Bukkit.getOnlinePlayers()) {
            players.sendTitle(ColorUtil.fixColors(message), " ", 16, 24, 16);
            return;
        }
        return;
    }
    /*---------------------------------------------------*/
    public static void broadcastTitle(@NotNull String title, @NotNull String subtitle, @NotNull Player player) {
        for (Player players : Bukkit.getOnlinePlayers()) {
            players.sendTitle(ColorUtil.fixColors(title), ColorUtil.fixColors(subtitle), 16, 24, 16);
            return;
        }
        return;
    }
    /*---------------------------------------------------*/
    public static void broadcastTitle(@NotNull String title, @NotNull String subtitle, int fadein, int stayin, int fadeout, @NotNull Player player) {
        for (Player players : Bukkit.getOnlinePlayers()) {
            players.sendTitle(ColorUtil.fixColors(title), ColorUtil.fixColors(subtitle), fadein, stayin, fadeout);
            return;
        }
        return;
    }
    /*---------------------------------------------------*/
}