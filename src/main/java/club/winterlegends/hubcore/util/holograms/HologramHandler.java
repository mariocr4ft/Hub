package club.winterlegends.hubcore.util.holograms;


import club.winterlegends.hubcore.HubCore;
import eu.decentsoftware.holograms.api.holograms.Hologram;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

public class HologramHandler {
    public static String holoID;

    public static Plugin PLUGIN = HubCore.PLUGIN;
    public void newHologram(String name, Location loc){
        Hologram newHologram = new Hologram(name, loc);
        newHologram.getId();
        holoID = newHologram.getId();
    }




}
