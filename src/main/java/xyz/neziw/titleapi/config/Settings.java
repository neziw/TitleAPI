package xyz.neziw.titleapi.config;

import org.bukkit.plugin.Plugin;

import java.util.List;

public class Settings {

    /*---------------------------------------------------*/
    public static String getString(String path, Plugin plugin) {
        return plugin.getConfig().getString(path);
    }
    /*---------------------------------------------------*/
    public static Integer getInteger(String path, Plugin plugin) {
        return plugin.getConfig().getInt(path);
    }
    /*---------------------------------------------------*/
    public static List<String> getStringList(String path, Plugin plugin) {
        return plugin.getConfig().getStringList(path);
    }
    /*---------------------------------------------------*/
}
