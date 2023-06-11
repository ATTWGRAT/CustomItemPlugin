package attwgrat.customitemplugin.classes;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public abstract class CustomCraftedItem {
    public abstract ItemStack getItem();

    public abstract NamespacedKey getKey();

    public abstract ShapedRecipe getRecipe();

}
