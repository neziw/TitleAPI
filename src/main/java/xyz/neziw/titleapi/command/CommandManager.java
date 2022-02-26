package xyz.neziw.titleapi.command;

import xyz.neziw.titleapi.TitleAPI;
import xyz.neziw.titleapi.command.list.TitleCommand;

public class CommandManager {

    /*---------------------------------------------------*/
    @Deprecated
    public void registerCommands(TitleAPI titleAPI) {
        titleAPI.getCommand("title").setExecutor(new TitleCommand());
    }
    /*---------------------------------------------------*/
    public static void registerCommands() {
        TitleAPI.getInstance().getCommand("title").setExecutor(new TitleCommand());
    }
}
