package xyz.neziw.titleapi.api.sender;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import xyz.neziw.titleapi.util.ColorUtil;

public class SubtitleSender {

    /*---------------------------------------------------*/
    public static void sendSubTitle(@NotNull String message, @NotNull Player player) {
        player.sendTitle(" ", ColorUtil.fixColors(message), 16, 24, 16);
        return;
    }
    /*---------------------------------------------------*/
    public static void sendSubTitle(@NotNull String message, int fadein, int stayin, int fadeout, @NotNull Player player) {
        player.sendTitle(" ", ColorUtil.fixColors(message), fadein, stayin, fadeout);
        return;
    }
    /*---------------------------------------------------*/
    public static void broadcastSubTitle(@NotNull String message, @NotNull Player player) {
        for (Player players : Bukkit.getOnlinePlayers()) {
            players.sendTitle(" ", ColorUtil.fixColors(message), 16, 24, 16);
            return;
        }
        return;
    }
    /*---------------------------------------------------*/
}
