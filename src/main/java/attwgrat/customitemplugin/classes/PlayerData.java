package attwgrat.customitemplugin.classes;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class PlayerData {
    private final UUID uuid;
    private final HashMap<Usable, Long> cooldowns;

    public PlayerData(Player p) {
        this.uuid = p.getUniqueId();
        this.cooldowns = new HashMap<>();
    }

    public UUID getUuid() {
        return uuid;
    }

    public HashMap<Usable, Long> getCooldowns() {
        return cooldowns;
    }
}
