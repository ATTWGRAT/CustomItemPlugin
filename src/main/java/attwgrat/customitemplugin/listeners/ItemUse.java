package attwgrat.customitemplugin.listeners;

import attwgrat.customitemplugin.CustomItemManager;
import attwgrat.customitemplugin.CustomItemPlugin;
import attwgrat.customitemplugin.classes.Usable;
import attwgrat.customitemplugin.items.TeleportBow;
import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;

public class ItemUse implements Listener {
    @EventHandler
    public void playerInteract(PlayerInteractEvent e) {
        CustomItemManager manager = CustomItemPlugin.getInstance().getItemManager();
        if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            HashMap<Usable, Long> cooldowns = CustomItemPlugin.getInstance().getPlayerData().get(e.getPlayer().getUniqueId()).getCooldowns();
            manager.getUsables().forEach(usable -> {
                if(usable.getItem().isSimilar(e.getItem())) {
                    if(!e.getPlayer().hasPermission("cip.useitems")) {
                        e.getPlayer().sendMessage(ChatColor.RED + "You don't have the permission to use this item!");
                        return;
                    }
                    if(cooldowns.containsKey(usable)) {
                        if(cooldowns.get(usable) > System.currentTimeMillis()) {
                            e.getPlayer().sendMessage(ChatColor.RED + "This item is still on cooldown for " + (int) Math.ceil((cooldowns.get(usable) - System.currentTimeMillis())/ (double) 1000) + " seconds!");
                            return;
                        }
                    }
                    usable.use(e.getPlayer(), e.getPlayer().getNearbyEntities(5, 5, 5), e.getClickedBlock());
                    CustomItemPlugin.getInstance()
                            .getPlayerData()
                            .get(e.getPlayer().getUniqueId())
                            .getCooldowns()
                            .put(usable, System.currentTimeMillis() + usable.getCooldown());
                }
            });
        }
    }

    @EventHandler
    public void onArrowHit(ProjectileHitEvent e) {
        if(e.isCancelled()) return;
        if(e.getEntity() instanceof Arrow) {
            if(e.getEntity().getShooter() instanceof Player) {
                if(((Player) e.getEntity().getShooter())
                        .getItemInHand()
                        .isSimilar(CustomItemPlugin
                                .getInstance()
                                .getItemManager()
                                .getItemList().get(0).getItem())) {
                    if(e.getHitEntity() != null) {
                        ((Player) e.getEntity().getShooter()).teleport(e.getHitEntity().getLocation());
                    } else if(e.getHitBlock() != null) {
                        ((Player) e.getEntity().getShooter()).teleport(e.getHitBlock().getLocation());
                    }
                }
            }
        }
    }
}
