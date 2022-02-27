package xyz.neziw.titleapi.update;

import xyz.neziw.titleapi.TitleAPI;
import xyz.neziw.titleapi.util.ConnectionUtil;

public class UpdateChecker {

    private static final String currentVersion = "1.2";

    public static void checkForUpdates() {
        TitleAPI plugin = TitleAPI.getInstance();
        plugin.getLogger().info("Checking for updates...");
        ConnectionUtil connectionUtil = new ConnectionUtil("https://neziw.xyz/titleapi/version.txt");
        if(connectionUtil.getOutput() != null && !(connectionUtil.getOutput().equals(currentVersion))) {
            plugin.getLogger().info("--------------------------------------");
            plugin.getLogger().info("Update found!");
            plugin.getLogger().info("Your version: "+currentVersion);
            plugin.getLogger().info("New version: "+ connectionUtil.getOutput());
            plugin.getLogger().info(" ---> https://www.spigotmc.org/resources/titleapi.100336/");
            plugin.getLogger().info("---------------------------------------");
        } else {
            plugin.getLogger().info("No new updates!");
        }
    }
}
