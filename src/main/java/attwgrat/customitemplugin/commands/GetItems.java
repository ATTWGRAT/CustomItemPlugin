package attwgrat.customitemplugin.commands;

import attwgrat.customitemplugin.CustomItemPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public class GetItems implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) return true;
        Player p = (Player) commandSender;
        CustomItemPlugin.getInstance().getItemManager().getItemList().forEach(item -> {
            if(!p.getInventory().addItem(item.getItem()).isEmpty()) {
                Bukkit.getWorlds().get(0).dropItem(p.getLocation(), item.getItem());
            }
        });
        p.sendMessage(ChatColor.GREEN + "You were given all of the custom items!");
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return Collections.emptyList();
    }
}
