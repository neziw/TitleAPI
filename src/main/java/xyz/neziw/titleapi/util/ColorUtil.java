package xyz.neziw.titleapi.util;

import net.md_5.bungee.api.ChatColor;

public class ColorUtil {

    /*---------------------------------------------------*/
    public static String fixColors(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
    /*---------------------------------------------------*/
}
