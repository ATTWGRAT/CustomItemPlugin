package attwgrat.customitemplugin.listeners;

import attwgrat.customitemplugin.CustomItemPlugin;
import attwgrat.customitemplugin.classes.PlayerData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.UUID;

public class PlayerJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        HashMap<UUID, PlayerData> data = CustomItemPlugin.getInstance().getPlayerData();
        if(!data.containsKey(e.getPlayer().getUniqueId())) {
            data.put(e.getPlayer().getUniqueId(), new PlayerData(e.getPlayer()));
        }
    }
}
