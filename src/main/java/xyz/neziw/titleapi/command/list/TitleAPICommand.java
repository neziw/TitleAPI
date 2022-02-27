package xyz.neziw.titleapi.command.list;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.neziw.titleapi.TitleAPI;
import xyz.neziw.titleapi.config.Settings;
import xyz.neziw.titleapi.update.UpdateChecker;
import xyz.neziw.titleapi.util.ColorUtil;

public class TitleAPICommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        TitleAPI plugin = TitleAPI.getInstance();
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("titleapi.command.main")) {
                if (args.length == 0) {
                    player.sendMessage(ColorUtil.fixColors("&8~~~~~~~~~~~~~~~~~~~ &6&lTitleAPI &r&8~~~~~~~~~~~~~~~~~~~"));
                    player.sendMessage(ColorUtil.fixColors("&8> &e/titleapi update &7- check for plugin updates"));
                    player.sendMessage(ColorUtil.fixColors("&8> &e/titleapi reload &7- reload configuration file"));
                    player.sendMessage(ColorUtil.fixColors("&8> &e/alert [message] &7- send subtitle to all players"));
                    player.sendMessage(ColorUtil.fixColors("&8> &e/actionbar [message] &7- send actionbar to all players"));
                    player.sendMessage(ColorUtil.fixColors(""));
                    player.sendMessage(ColorUtil.fixColors("&7More commands? You can do it with my API!"));
                    player.sendMessage(ColorUtil.fixColors("&7See JavaDocs - &ehttps://neziw.xyz/titleapi/"));
                    player.sendMessage(ColorUtil.fixColors("&8~~~~~~~~~~~~~~~~~~~ &6&lTitleAPI &r&8~~~~~~~~~~~~~~~~~~~"));
                    return true;
                }
                if (args.length >= 1) {
                    if (args[0].equals("reload")) {
                        plugin.getConfiguration().reload(plugin);
                        player.sendMessage(ColorUtil.fixColors(Settings.getString("messages.reloaded", plugin)));
                        return true;
                    }
                    if (args[0].equals("update")) {
                        UpdateChecker.checkForUpdates();
                        player.sendMessage(ColorUtil.fixColors(Settings.getString("messages.update-checked", plugin)));
                        return true;
                    } else {
                        player.sendMessage(ColorUtil.fixColors("&8~~~~~~~~~~~~~~~~~~~ &6&lTitleAPI &r&8~~~~~~~~~~~~~~~~~~~"));
                        player.sendMessage(ColorUtil.fixColors("&8> &e/titleapi update &7- check for plugin updates"));
                        player.sendMessage(ColorUtil.fixColors("&8> &e/titleapi reload &7- reload configuration file"));
                        player.sendMessage(ColorUtil.fixColors("&8> &e/alert [message] &7- send subtitle to all players"));
                        player.sendMessage(ColorUtil.fixColors("&8> &e/actionbar [message] &7- send actionbar to all players"));
                        player.sendMessage(ColorUtil.fixColors(""));
                        player.sendMessage(ColorUtil.fixColors("&7More commands? You can do it with my API!"));
                        player.sendMessage(ColorUtil.fixColors("&7See JavaDocs - &ehttps://neziw.xyz/titleapi/"));
                        player.sendMessage(ColorUtil.fixColors("&8~~~~~~~~~~~~~~~~~~~ &6&lTitleAPI &r&8~~~~~~~~~~~~~~~~~~~"));
                        return true;
                    }
                }
            } else {
                player.sendMessage(ColorUtil.fixColors(Settings.getString("messages.no-permission", plugin)));
                return true;
            }
        } else {
            sender.sendMessage(ColorUtil.fixColors(Settings.getString("messages.only-players", plugin)));
            return true;
        }
        return true;
    }
}
