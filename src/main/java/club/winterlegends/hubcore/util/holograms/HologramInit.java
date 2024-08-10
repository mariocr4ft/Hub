package club.winterlegends.hubcore.util.holograms;

import club.winterlegends.hubcore.HubCore;
import eu.decentsoftware.holograms.api.holograms.Hologram;
import eu.decentsoftware.holograms.api.holograms.HologramManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.Collection;

public class HologramInit {
    private static eu.decentsoftware.holograms.api.DecentHolograms DecentHolograms;
    public static HubCore MAIN;
    public static boolean ENABLED;

    public HologramInit() {
        load();
    }

    private void load() {
        if (HubCore.CONFIG.getBoolean("HOLOGRAMS")) {
            if (Bukkit.getPluginManager().getPlugin("DecentHolograms") != null || !Bukkit.getPluginManager().getPlugin("DecentHolograms").isEnabled()) {
                try {
                        HologramManager manager = new HologramManager(DecentHolograms);
                        DecentHolograms.reload();
                        Collection<Hologram> holograms = manager.getHolograms();
                        for (Hologram hologram : holograms) {
                            hologram.register();
                            hologram.save();
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
