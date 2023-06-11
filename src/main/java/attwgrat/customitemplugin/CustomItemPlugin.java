package attwgrat.customitemplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class CustomItemPlugin extends JavaPlugin {
    private CustomItemPlugin instance;
    private Logger log;
    @Override
    public void onEnable() {
       instance = this;
       log = Bukkit.getLogger();

    }

    public CustomItemPlugin getInstance() {
        return instance;
    }

    public Logger getLog() {
        return log;
    }
}
