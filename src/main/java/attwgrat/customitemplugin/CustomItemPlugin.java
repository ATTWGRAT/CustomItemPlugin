package attwgrat.customitemplugin;

import attwgrat.customitemplugin.classes.CustomCraftedItem;
import attwgrat.customitemplugin.classes.PlayerData;
import attwgrat.customitemplugin.commands.GetItem;
import attwgrat.customitemplugin.commands.GetItems;
import attwgrat.customitemplugin.listeners.ItemUse;
import attwgrat.customitemplugin.listeners.PlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public final class CustomItemPlugin extends JavaPlugin {
    private HashMap<UUID, PlayerData> playerData;
    private static CustomItemPlugin instance;
    private Logger log;
    private CustomItemManager itemManager;
    @Override
    public void onEnable() {
       instance = this;
       log = Bukkit.getLogger();
       itemManager = new CustomItemManager();
       playerData = new HashMap<>();

        Bukkit.getPluginManager().registerEvents(new ItemUse(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);

        this.getCommand("getitem").setExecutor(new GetItem());
        this.getCommand("getitems").setExecutor(new GetItems());
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

    public HashMap<UUID, PlayerData> getPlayerData() {
        return playerData;
    }
}
