package xyz.neziw.titleapi.command;

import xyz.neziw.titleapi.TitleAPI;
import xyz.neziw.titleapi.command.list.TitleCommand;

public class CommandManager {

    /*---------------------------------------------------*/
    public void registerCommands(TitleAPI titleAPI) {
        titleAPI.getCommand("title").setExecutor(new TitleCommand());
    }
    /*---------------------------------------------------*/
}
