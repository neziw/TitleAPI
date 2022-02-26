package xyz.neziw.titleapi.api;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.TestOnly;
import xyz.neziw.titleapi.util.ColorUtil;

public class TitleSender {

    /*---------------------------------------------------*/
    public void sendTitle(String message, Player player) {
        player.sendTitle(ColorUtil.fixColors(message), " ", 24, 30, 24);
        return;
    }
    /*---------------------------------------------------*/
    public void sendSubTitle(String message, Player player) {
        player.sendTitle(" ", ColorUtil.fixColors(message), 24, 30, 24);
        return;
    }
    /*---------------------------------------------------*/
    public void sendActionBar(String message, Player player) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ColorUtil.fixColors(message)));
        return;
    }
    /*---------------------------------------------------*/
    @TestOnly
    public void broadcastActionBar(String message, boolean usepermission, String... permission) {
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
            }
        }
    }
    /*---------------------------------------------------*/
}
