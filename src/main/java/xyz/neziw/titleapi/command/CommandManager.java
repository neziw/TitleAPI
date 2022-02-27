package xyz.neziw.titleapi.command;

import xyz.neziw.titleapi.TitleAPI;
import xyz.neziw.titleapi.command.list.ActionbarCommand;
import xyz.neziw.titleapi.command.list.AlertCommand;
import xyz.neziw.titleapi.command.list.TitleAPICommand;

public class CommandManager {

    /*---------------------------------------------------*/
    public static void registerCommands() {
        TitleAPI plugin = TitleAPI.getInstance();
        plugin.getCommand("titleapi").setExecutor(new TitleAPICommand());
        plugin.getCommand("alert").setExecutor(new AlertCommand());
        plugin.getCommand("actionbar").setExecutor(new ActionbarCommand());
    }
    /*---------------------------------------------------*/
}
