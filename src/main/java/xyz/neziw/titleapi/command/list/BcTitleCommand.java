package xyz.neziw.titleapi.command.list;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.neziw.titleapi.TitleAPI;
import xyz.neziw.titleapi.config.Settings;
import xyz.neziw.titleapi.util.ColorUtil;

public class BcTitleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        TitleAPI plugin = TitleAPI.getInstance();
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (!player.hasPermission("titleapi.broadcast.title")) {
                player.sendMessage(ColorUtil.fixColors(Settings.getString("messages.no-permission", plugin)));
                return true;
            }
            if (args.length == 0) {
                player.sendMessage(ColorUtil.fixColors("&8> &7Correct usage: &e/bctitle [message]"));
                return true;
            }
            if (args.length >= 1) {

            }
        }
        return true;
    }
}
