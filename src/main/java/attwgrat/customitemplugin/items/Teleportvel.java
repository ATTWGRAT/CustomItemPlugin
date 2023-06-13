package attwgrat.customitemplugin.items;

import attwgrat.customitemplugin.CustomItemPlugin;
import attwgrat.customitemplugin.classes.CustomCraftedItem;
import attwgrat.customitemplugin.classes.Usable;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import java.util.Collections;
import java.util.List;

public class Teleportvel extends CustomCraftedItem implements Usable {
    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;
    private final long cooldown;

    public Teleportvel() {
        cooldown = 1000;
        key = new NamespacedKey(CustomItemPlugin.getInstance(), "Teleportvel");
        item = new ItemStack(Material.NETHERITE_SHOVEL);

        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(Enchantment.LUCK, 100, true);
        meta.setDisplayName(ChatColor.AQUA + "Teleportvel");
        meta.setLore(Collections.singletonList(ChatColor.DARK_PURPLE + "Teleports you by 5 blocks! Weird stuff!"));
        meta.setUnbreakable(true);
        item.setItemMeta(meta);

        recipe = new ShapedRecipe(key, item);
        recipe.shape("XYX", "YZY", "XYX");
        recipe.setIngredient('X', Material.DIAMOND_BLOCK);
        recipe.setIngredient('Y', Material.ENDER_EYE);
        recipe.setIngredient('Z', Material.NETHERITE_SHOVEL);
    }
    @Override
    public void use(Player user, List<Entity> usedOn, Block usedBlock) {
        Vector direction = user.getEyeLocation().getDirection().normalize().multiply(5);
        Location teleLoc = user.getLocation().add(direction);
        if(teleLoc.getBlock().getType().equals(Material.WATER)) {
            user.sendMessage(ChatColor.RED + "Can't teleport under water!");
            return;
        }
        direction.normalize();
        while(!teleLoc.getBlock().getType().equals(Material.AIR) && !teleLoc.getBlock().getLocation().equals(user.getLocation().getBlock().getLocation())) {
            teleLoc.subtract(direction);
        }
        user.teleport(teleLoc);
        user.playSound(user, Sound.ENTITY_ENDERMAN_SCREAM, 1, 1);
    }

    @Override
    public String getName() {
        return "TELEPORTVEL";
    }

    @Override
    public ItemStack getItem() {
        return item;
    }

    @Override
    public long getCooldown() {
        return cooldown;
    }

    @Override
    public NamespacedKey getKey() {
        return key;
    }

    @Override
    public ShapedRecipe getRecipe() {
        return recipe;
    }
}
