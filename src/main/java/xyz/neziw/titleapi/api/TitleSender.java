package xyz.neziw.titleapi.api;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import xyz.neziw.titleapi.util.ColorUtil;

public class TitleSender {

    /*---------------------------------------------------*/
    public void sendTitle(@NotNull String string, Player player) {
        player.sendTitle(ColorUtil.fixColors(string), "", 24, 30, 24);
        return;
    }
    /*---------------------------------------------------*/
    public void sendSubTitle(@NotNull String string, Player player) {
        player.sendTitle("", ColorUtil.fixColors(string), 24, 30, 24);
        return;
    }
    /*---------------------------------------------------*/
}
