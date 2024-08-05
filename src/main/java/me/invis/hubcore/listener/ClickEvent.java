package me.invis.hubcore.listener;

import me.invis.hubcore.HubCore;
import me.invis.hubcore.config.ConfigManager;
import me.invis.hubcore.config.managers.*;
import me.invis.hubcore.config.managers.GameMode;
import me.invis.hubcore.util.enums.Type;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ClickEvent implements Listener {
    ConfigManager configManager = HubCore.CONFIG_MANAGER;

    @EventHandler
    private void onClick(PlayerInteractEvent event) {
        ServersListItem hubItem = configManager.serversListItem(event.getPlayer());
        VisibilityItem visibilityItem = configManager.visibilityItem(event.getPlayer());
        ItemStack visibilityItemStack = visibilityItem.item().keySet().toArray(new ItemStack[0])[0];

        ItemStack item = event.getItem();

        if(     item == null
                || item.getType() == Material.AIR
                || !item.hasItemMeta()) return;

        ItemMeta itemMeta = item.getItemMeta();

        if(itemMeta.getDisplayName().equalsIgnoreCase(hubItem.itemStack().getItemMeta().getDisplayName()) &&
                event.getAction().toString()
                        .contains(
                                hubItem.trigger().toString().split("_")[0])) {

            event.setCancelled(true);
            new ServerListItemAction(event.getPlayer());
        }
        else if(itemMeta.getDisplayName().equalsIgnoreCase(visibilityItemStack.getItemMeta().getDisplayName())) {

            event.setCancelled(true);
            new VisibilityItemAction(event.getPlayer());
        }
    }

    @EventHandler
    private void onInvClick(InventoryClickEvent event) {
        if(event.getCurrentItem() == null) return;
        if(!event.getCurrentItem().hasItemMeta()) return;
        Player clicker = (Player) event.getWhoClicked();
        HubInventory hubInventory = configManager.hubInventory(clicker);
        if(!event.getInventory().getName().equalsIgnoreCase(hubInventory.title())) return;
        event.setCancelled(true);
        for(GameMode gameMode : hubInventory.gameModes()) {
            String command = gameMode.command();
            if(gameMode.itemStack().getItemMeta().getDisplayName().equalsIgnoreCase(event.getCurrentItem().getItemMeta().getDisplayName())) {
                switch (configManager.type()){
                    case BUNGEECORD:
                        Bukkit.dispatchCommand(clicker, "server " + gameMode.name());
                        break;
                    case WORLD:
                        World world = Bukkit.getWorld(gameMode.name());
                        Location l = world.getSpawnLocation();
                        clicker.teleport(new Location(world, l.getX(), l.getY(), l.getZ()));
                        break;
                    case COMMAND:
                        commandOK(clicker, command);
                }

            }
        }

    }
    public void commandOK(Player player, String command){
        try{
            player.performCommand(command);
            Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+player.getName()+" executed "+command+".");

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
