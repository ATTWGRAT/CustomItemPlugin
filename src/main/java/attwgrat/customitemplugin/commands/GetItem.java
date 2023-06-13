package attwgrat.customitemplugin.commands;

import attwgrat.customitemplugin.CustomItemManager;
import attwgrat.customitemplugin.CustomItemPlugin;
import attwgrat.customitemplugin.classes.CustomCraftedItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GetItem implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) return true;
        Player p = (Player) commandSender;
        if(strings.length != 1) {
            return false;
        }
        CustomCraftedItem item = CustomItemPlugin.getInstance().getItemManager().getItemByName(strings[0]);
        if(item == null) {
            p.sendMessage(ChatColor.RED + "Can't find an item with that name!");
            return true;
        }
        p.sendMessage(ChatColor.GREEN + "You have been given the item!");
        if(!p.getInventory().addItem(item.getItem()).isEmpty()) {
            Bukkit.getWorlds().get(0).dropItem(p.getLocation(), item.getItem());
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length == 1) {
            return CustomItemPlugin.getInstance().getItemManager().getItemList().stream().flatMap(item -> Stream.of(item.getName())).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
