package attwgrat.customitemplugin.items;

import attwgrat.customitemplugin.CustomItemPlugin;
import attwgrat.customitemplugin.classes.CustomCraftedItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class TeleportBow extends CustomCraftedItem {
    private final ItemStack item;
    private final NamespacedKey key;
    private final ShapedRecipe recipe;

    public TeleportBow() {
        key = new NamespacedKey(CustomItemPlugin.getInstance(), "TeleportBow");
        item = new ItemStack(Material.BOW);

        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(Enchantment.ARROW_INFINITE, 100, true);
        meta.setDisplayName(ChatColor.AQUA + "TeleportBow");
        meta.setLore(Collections.singletonList(ChatColor.DARK_PURPLE + "Shoot to teleport!"));
        meta.setUnbreakable(true);
        item.setItemMeta(meta);

        recipe = new ShapedRecipe(key, item);
        recipe.shape("XYX", "YZY", "XYX");
        recipe.setIngredient('X', Material.NETHERITE_BLOCK);
        recipe.setIngredient('Y', Material.ENDER_EYE);
        recipe.setIngredient('Z', Material.BOW);
    }

    @Override
    public String getName() {
        return "TELEPORTBOW";
    }

    @Override
    public ItemStack getItem() {
        return item;
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
