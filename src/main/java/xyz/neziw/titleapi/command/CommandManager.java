package xyz.neziw.titleapi.command;

import xyz.neziw.titleapi.TitleAPI;

public class CommandManager {

    /*---------------------------------------------------*/
    @Deprecated
    public void registerCommands(TitleAPI titleAPI) {
        //titleAPI.getCommand("title").setExecutor(new TitleCommand());
    }
    /*---------------------------------------------------*/
    public static void registerCommands() {
        //TitleAPI.getInstance().getCommand("title").setExecutor(new TitleCommand());
        //TitleAPI.getInstance().getCommand("title-broadcast").setExecutor(new BcTitleCommand());
        //TitleAPI.getInstance().getCommand("title").setExecutor(new TitleCommand());
    }
}
