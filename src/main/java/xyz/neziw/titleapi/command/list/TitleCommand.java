package xyz.neziw.titleapi.command.list;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.neziw.titleapi.TitleAPI;
import xyz.neziw.titleapi.config.Settings;
import xyz.neziw.titleapi.util.ColorUtil;

public class TitleCommand implements CommandExecutor {

    /*---------------------------------------------------*/
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        TitleAPI plugin = TitleAPI.getInstance();
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!player.hasPermission("titleapi.testcommand")) {
                player.sendMessage(ColorUtil.fixColors(Settings.getString("messages.no-permission", plugin)));
                return true;
            }
            if (args.length == 0) {
                player.sendMessage(" ");
                player.sendMessage(ColorUtil.fixColors("&8> &6&lTitleAPI &r&7- Commands:"));
                player.sendMessage(ColorUtil.fixColors("&8> &e/title title [player] &7- send test title to player"));
                player.sendMessage(ColorUtil.fixColors("&8> &e/title subtitle [player] &7- send test subtitle to player"));
                player.sendMessage(ColorUtil.fixColors("&8> &e/title actionbar [player] &7- send test actionbar to player"));
                player.sendMessage(ColorUtil.fixColors("&8> &e/title all [player] &7- send test title, subtitle and actionbar to player"));
                player.sendMessage(" ");
                return true;
            }
            if (args.length == 1) {
                player.sendMessage(" ");
                player.sendMessage(ColorUtil.fixColors("&8> &6&lTitleAPI &r&7- Commands:"));
                player.sendMessage(ColorUtil.fixColors("&8> &e/title title [player] &7- send test title to player"));
                player.sendMessage(ColorUtil.fixColors("&8> &e/title subtitle [player] &7- send test subtitle to player"));
                player.sendMessage(ColorUtil.fixColors("&8> &e/title actionbar [player] &7- send test actionbar to player"));
                player.sendMessage(ColorUtil.fixColors("&8> &e/title all [player] &7- send test title, subtitle and actionbar to player"));
                player.sendMessage(" ");
                return true;
            }
            if (args.length >= 2) {
                Player target = Bukkit.getPlayer(args[1]);
                if (target.isOnline() || target != null) {
                    if (args[0].equals("title")) {
                        player.sendMessage(ColorUtil.fixColors(Settings.getString("messages.test-sent".replace("{PLAYER}", target.getName()), plugin)));
                        TitleAPI.getTitleSender().sendTitle(Settings.getString("messages.test-title", plugin), player);
                        return true;
                    }
                    if (args[0].equals("subtitle")) {
                        player.sendMessage(ColorUtil.fixColors(Settings.getString("messages.test-sent".replace("{PLAYER}", target.getName()), plugin)));
                        TitleAPI.getTitleSender().sendSubTitle(Settings.getString("messages.test-subtitle", plugin), player);
                        return true;
                    }
                    if (args[0].equals("actionbar")) {
                        player.sendMessage(ColorUtil.fixColors(Settings.getString("messages.test-sent".replace("{PLAYER}", target.getName()), plugin)));
                        TitleAPI.getTitleSender().sendActionBar(Settings.getString("messages.test-actionbar", plugin), player);
                        return true;
                    }
                    if (args[0].equals("all")) {
                        player.sendMessage(ColorUtil.fixColors(Settings.getString("messages.test-sent".replace("{PLAYER}", target.getName()), plugin)));
                        TitleAPI.getTitleSender().send(Settings.getString("messages.test-title", plugin), Settings.getString("messages.test-subtitle", plugin), player);
                        return true;
                    } else {
                        player.sendMessage(" ");
                        player.sendMessage(ColorUtil.fixColors("&8> &6&lTitleAPI &r&7- Commands:"));
                        player.sendMessage(ColorUtil.fixColors("&8> &e/title title [player] &7- send test title to player"));
                        player.sendMessage(ColorUtil.fixColors("&8> &e/title subtitle [player] &7- send test subtitle to player"));
                        player.sendMessage(ColorUtil.fixColors("&8> &e/title actionbar [player] &7- send test actionbar to player"));
                        player.sendMessage(ColorUtil.fixColors("&8> &e/title all [player] &7- send test title, subtitle and actionbar to player"));
                        player.sendMessage(" ");
                        return true;
                    }
                }
                player.sendMessage(ColorUtil.fixColors(Settings.getString("messages.target-offline", plugin)));
            }
            return true;
        }
        sender.sendMessage(ColorUtil.fixColors(Settings.getString("messages.only-players", plugin)));
        return true;
    }
    /*---------------------------------------------------*/
}
