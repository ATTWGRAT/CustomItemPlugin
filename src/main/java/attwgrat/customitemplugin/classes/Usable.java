package attwgrat.customitemplugin.classes;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

import java.util.List;

public interface Usable {
    void use(Player user, List<Player> usedOn, Block usedBlock);
    Permission permission = new Permission("customItemUse");

}
