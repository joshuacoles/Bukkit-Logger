package jwf.bukkit.loggerExtreme;

import org.bukkit.plugin.java.JavaPlugin;
import static jwf.bukkit.loggerExtreme.Util.initFiles;
import static jwf.bukkit.loggerExtreme.Util.rotateLogs;
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
        rotateLogs();
    }

    @Override
    public void onEnable() {
        System.out.println("================================|Logger Extreme Enabling|================================");
        LogListener listener = new LogListener();
        getServer().getPluginManager().registerEvents(listener, this);
        initFiles();
    }
}
