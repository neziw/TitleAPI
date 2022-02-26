package xyz.neziw.titleapi.config;

import org.bukkit.plugin.Plugin;

public class Config {

    /*---------------------------------------------------*/
    public void saveDefaultConfig(Plugin plugin) {
        try {
            plugin.saveDefaultConfig();
            return;
        } catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }
    /*---------------------------------------------------*/
    public void reload(Plugin plugin) {
        try {
            plugin.reloadConfig();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    /*---------------------------------------------------*/
}
