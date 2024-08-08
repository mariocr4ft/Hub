package club.winterlegends.hubcore.config.managers;

import club.winterlegends.hubcore.HubCore;
import club.winterlegends.hubcore.util.ItemAction;
import org.bukkit.entity.Player;

public class ServerListItemAction {
    public ServerListItemAction(Player target) {
        new ItemAction(target, HubCore.CONFIG_MANAGER.serversListItem(target).action());
    }
}
