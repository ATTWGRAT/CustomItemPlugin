package attwgrat.customitemplugin.listeners;

import attwgrat.customitemplugin.CustomItemManager;
import attwgrat.customitemplugin.CustomItemPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ItemUse implements Listener {
    @EventHandler
    public void playerInteract(PlayerInteractEvent e) {
        CustomItemManager manager = CustomItemPlugin.getInstance().getItemManager();
        if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            manager.getUsables().forEach(usable -> {
                if(usable.getItem().isSimilar(e.getItem())) {
                    usable.use(e.getPlayer(), e.getPlayer().getNearbyEntities(5, 5, 5), e.getClickedBlock());
                }
            });
        }
    }
}
