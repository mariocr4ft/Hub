package club.winterlegends.hubcore.util.holograms;

import eu.decentsoftware.holograms.api.holograms.Hologram;
import eu.decentsoftware.holograms.api.holograms.HologramManager;
import club.winterlegends.hubcore.HubCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.Collection;

public class HologramInit {
    public static HologramManager MANAGER;
    public static HubCore MAIN;
    public static boolean ENABLED;

    public HologramInit() {
        load();
    }

    private void load() {
        Collection<Hologram> hologramList = MANAGER.getHolograms();
        if (HubCore.CONFIG.getBoolean("HOLOGRAMS")) {
            if (Bukkit.getPluginManager().getPlugin("DecentHolograms") != null || !Bukkit.getPluginManager().getPlugin("DecentHolograms").isEnabled()) {
                try {
                    for (Hologram hologram : hologramList) {
                        hologram.hideAll();
                        hologram.showAll();
                        MANAGER.reload();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "Holograms couldn't load properly. Please check decentholograms version.");
                    MAIN.getServer().getPluginManager().disablePlugin(MAIN);
                }
            } else {
                ENABLED = false;

            }
        } else {
            ENABLED = false;
        }
    }
}
