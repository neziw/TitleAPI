package xyz.neziw.titleapi.api;

import org.bukkit.entity.Player;
import xyz.neziw.titleapi.util.ColorUtil;

public class TitleSender {

    /*---------------------------------------------------*/
    public void sendTitle(String string, Player player) {
        player.sendTitle(ColorUtil.fixColors(string), " ", 24, 30, 24);
        return;
    }
    /*---------------------------------------------------*/
    public void sendSubTitle(String string, Player player) {
        player.sendTitle(" ", ColorUtil.fixColors(string), 24, 30, 24);
        return;
    }
    /*---------------------------------------------------*/
}
