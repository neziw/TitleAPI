package xyz.neziw.titleapi.command.list;

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
        TitleAPI plugin = new TitleAPI();
        if (sender instanceof Player) {
            return true;
        }
        sender.sendMessage(ColorUtil.fixColors(Settings.getString("messages.only-players", plugin)));
        return true;
    }
    /*---------------------------------------------------*/
}
