package attwgrat.customitemplugin.items;

import attwgrat.customitemplugin.CustomItemPlugin;
import attwgrat.customitemplugin.classes.CustomCraftedItem;
import attwgrat.customitemplugin.classes.Usable;
import attwgrat.customitemplugin.util.GenerateExplosion;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.Collections;
import java.util.List;

public final class Excalibur extends CustomCraftedItem implements Usable {
    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;
    private final long cooldown;
    public Excalibur() {
        cooldown = 10000;
        key = new NamespacedKey(CustomItemPlugin.getInstance(), "Excalibur");
        item = new ItemStack(Material.NETHERITE_SWORD);

        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(Enchantment.DAMAGE_ALL, 100, true);
        meta.setDisplayName(ChatColor.AQUA + "Excalibur");
        meta.setLore(Collections.singletonList(ChatColor.DARK_PURPLE + "The greatest sword"));
        meta.setUnbreakable(true);
        item.setItemMeta(meta);

        recipe = new ShapedRecipe(key, item);
        recipe.shape("XYX", "YZY", "XYX");
        recipe.setIngredient('X', Material.DIAMOND_BLOCK);
        recipe.setIngredient('Y', Material.NETHERITE_BLOCK);
        recipe.setIngredient('Z', Material.NETHERITE_SWORD);
    }

    @Override
    public String getName() {
        return "EXCALIBUR";
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

    @Override
    public void use(Player user, List<Entity> usedOn, Block usedBlock) {
        Vector direction = user.getEyeLocation().getDirection().normalize().multiply(3);
        user.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 5, 1000));
        Location expLoc = user.getLocation();
        expLoc.add(direction);
        for (int i = 0; i < 8; i++) {
            expLoc.add(direction);
            new GenerateExplosion(expLoc.clone(), 4F).runTaskLater(CustomItemPlugin.getInstance(), i*2L);
        }
    }
}
