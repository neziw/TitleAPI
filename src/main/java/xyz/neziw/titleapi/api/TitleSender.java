package xyz.neziw.titleapi.api;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.TestOnly;
import xyz.neziw.titleapi.api.enums.Type;
import xyz.neziw.titleapi.util.ColorUtil;

public class TitleSender {

    /*---------------------------------------------------*/
    public void sendLegacyTitle(@NotNull String title, @NotNull String subtitle, int fadein, int stayin, int fadeout, @NotNull Player player) {
        player.sendTitle(ColorUtil.fixColors(title), ColorUtil.fixColors(subtitle), fadein, stayin, fadeout);
        return;
    }
    /*---------------------------------------------------*/
    public void sendTitle(@NotNull String message, @NotNull Player player) {
        player.sendTitle(ColorUtil.fixColors(message), " ", 24, 30, 24);
        return;
    }
    /*---------------------------------------------------*/
    public void sendSubTitle(@NotNull String message, @NotNull Player player) {
        player.sendTitle(" ", ColorUtil.fixColors(message), 24, 30, 24);
        return;
    }
    @Deprecated
    /*---------------------------------------------------*/
    public void send(@NotNull String title, @NotNull String subtitle, @NotNull Player player) {
        player.sendTitle(ColorUtil.fixColors(title), ColorUtil.fixColors(subtitle), 24, 30, 24);
        return;
    }
    /*---------------------------------------------------*/
    public void send(@NotNull Type type, @NotNull String message, @NotNull Player player) {
        if(type == Type.TITLE) {
            player.sendTitle(ColorUtil.fixColors(message), " ", 24, 34, 24);
            return;
        }
        if(type == Type.SUBTITLE) {
            player.sendTitle(" ", ColorUtil.fixColors(message), 24, 34, 24);
            return;
        }
        if(type == Type.ACTIONBAR) {
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ColorUtil.fixColors(message)));
            return;
        }
        return;
    }
    /*---------------------------------------------------*/
    public void sendActionBar(@NotNull String message, @NotNull Player player) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ColorUtil.fixColors(message)));
        return;
    }
    /*---------------------------------------------------*/
    @TestOnly
    public void broadcastActionBar(@NotNull String message, boolean usepermission, String... permission) {
        if(usepermission) {
            for(Player players : Bukkit.getOnlinePlayers()) {
                if(players.hasPermission(String.valueOf(permission))) {
                    players.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ColorUtil.fixColors(message)));
                    return;
                }
                return;
            }
            return;
        } else {
            for(Player players : Bukkit.getOnlinePlayers()) {
                players.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ColorUtil.fixColors(message)));
                return;
            }
            return;
        }
    }
    /*---------------------------------------------------*/
}
