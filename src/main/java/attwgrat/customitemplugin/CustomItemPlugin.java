package attwgrat.customitemplugin;

import attwgrat.customitemplugin.listeners.ItemUse;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class CustomItemPlugin extends JavaPlugin {
    private static CustomItemPlugin instance;
    private Logger log;
    private CustomItemManager itemManager;
    @Override
    public void onEnable() {
       instance = this;
       log = Bukkit.getLogger();
       itemManager = new CustomItemManager();

        Bukkit.getPluginManager().registerEvents(new ItemUse(), this);
    }

    public static CustomItemPlugin getInstance() {
        return instance;
    }

    public Logger getLog() {
        return log;
    }

    public CustomItemManager getItemManager() {
        return itemManager;
    }
}
