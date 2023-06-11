package attwgrat.customitemplugin;

import attwgrat.customitemplugin.classes.CustomCraftedItem;
import attwgrat.customitemplugin.classes.Usable;
import attwgrat.customitemplugin.items.Excalibur;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;

public class CustomItemManager {
    private final List<CustomCraftedItem> itemList = new ArrayList<>();
    private final List<Usable> usables = new ArrayList<>();
    public CustomItemManager() {
        itemList.add(new Excalibur());
        itemList.forEach(item -> {
            if(item instanceof Usable) {
                usables.add((Usable) item);
            }
            Bukkit.addRecipe(item.getRecipe());
        });
    }

    public List<CustomCraftedItem> getItemList() {
        return itemList;
    }

    public List<Usable> getUsables() {
        return usables;
    }
}
