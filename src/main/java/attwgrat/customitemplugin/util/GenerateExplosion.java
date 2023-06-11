package attwgrat.customitemplugin.util;

import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

public class GenerateExplosion extends BukkitRunnable {
    private Location loc;
    private Float power;
    public GenerateExplosion(Location loc, Float power) {
        this.loc = loc;
        this.power = power;
    }
    @Override
    public void run() {
        loc.getWorld().createExplosion(loc, power);
    }
}
