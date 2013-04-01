package jwf.bukkit.loggerExtreme;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * User: joshuac
 * Date: 30/03/2013
 * Time: 15:37
 */

public final class LoggerExtreme extends JavaPlugin {

    public LoggerExtreme() {

    }

    @Override
    public void onDisable() {
        System.out.println("================================|Logger Extreme Disabling|================================");
    }

    @Override
    public void onEnable() {
        System.out.println("================================|Logger Extreme Enabling|================================");
        LogListener listener = new LogListener();
        getServer().getPluginManager().registerEvents(listener, this);
        Util.initFiles();
    }
}
