package xyz.neziw.titleapi;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.neziw.titleapi.api.TitleSender;
import xyz.neziw.titleapi.command.CommandManager;
import xyz.neziw.titleapi.config.Config;
import xyz.neziw.titleapi.update.UpdateChecker;

public class TitleAPI extends JavaPlugin {

    /*---------------------------------------------------*/
    @Getter
    @Setter
    private static TitleAPI instance;
    /*---------------------------------------------------*/
    @Getter
    @Setter
    private Config configuration;
    /*---------------------------------------------------*/
    @Getter
    @Setter
    private CommandManager commandManager;
    /*---------------------------------------------------*/
    @Getter
    private static TitleSender titleSender;
    /*---------------------------------------------------*/
    public TitleAPI() {
        instance = this;
    }
    /*---------------------------------------------------*/
    public void onEnable() {
        this.configuration = new Config();
        titleSender = new TitleSender();
        this.commandManager = new CommandManager();
        this.configuration.saveDefaultConfig(this);
        UpdateChecker.checkForUpdates();
        //this.commandManager.registerCommands(getInstance());
        CommandManager.registerCommands();
    }
    /*---------------------------------------------------*/
}
