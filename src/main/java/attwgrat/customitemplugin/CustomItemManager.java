package attwgrat.customitemplugin;

import attwgrat.customitemplugin.classes.CustomCraftedItem;
import attwgrat.customitemplugin.classes.Usable;
import attwgrat.customitemplugin.items.Excalibur;
import attwgrat.customitemplugin.items.TeleportBow;
import attwgrat.customitemplugin.items.Teleportvel;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;

public class CustomItemManager {
    private final List<CustomCraftedItem> itemList = new ArrayList<>();
    private final List<Usable> usables = new ArrayList<>();
    public CustomItemManager() {
        itemList.add(new TeleportBow());
        itemList.add(new Excalibur());
        itemList.add(new Teleportvel());
        itemList.forEach(item -> {
            if(item instanceof Usable) {
                usables.add((Usable) item);
            }
            Bukkit.addRecipe(item.getRecipe());
        });
    }

    public CustomCraftedItem getItemByName(String name) {
        for (CustomCraftedItem item : itemList) {
            if(item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public List<CustomCraftedItem> getItemList() {
        return itemList;
    }

    public List<Usable> getUsables() {
        return usables;
    }
}
