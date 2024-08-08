package club.winterlegends.hubcore;

import club.winterlegends.hubcore.commands.ReloadConfigCommand;
import club.winterlegends.hubcore.config.ConfigManager;
import club.winterlegends.hubcore.listener.*;
import club.winterlegends.hubcore.util.holograms.HologramInit;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import dev.jcsoftware.jscoreboards.JPerPlayerMethodBasedScoreboard;
import club.winterlegends.hubcore.commands.CreateHologramCommand;
import club.winterlegends.hubcore.util.holograms.HologramHandler;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public final class HubCore extends JavaPlugin {

    public static HubCore PLUGIN;
    public static FileConfiguration CONFIG;
    public static ConfigManager CONFIG_MANAGER;
    public static ProtocolManager PROTOCOL_MANAGER;
    public static JPerPlayerMethodBasedScoreboard SCOREBOARD;
    public static boolean PAPI;
    public static HologramHandler HOLOGRAM;


    @Override
    public void onEnable() {
        PLUGIN = this;

        PAPI = Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null;
        PROTOCOL_MANAGER = ProtocolLibrary.getProtocolManager();

        saveDefaultConfig();
        CONFIG = getConfig();
        CONFIG_MANAGER = new ConfigManager();
        new HologramInit();

        SCOREBOARD = new JPerPlayerMethodBasedScoreboard();

        /* DESCRIPTION = this.getDescription(); */
        /* RUNTIME = Runtime.getRuntime(); */

        if (!PAPI) papiFAIL();

        event(
                new JoinEvent(),
                new ClickEvent(),
                new FlyToggleEvent(),
                new GeneralPrevent(),
                new ScoreboardApplier()
             );

        getCommand("hubcore").setExecutor(new CreateHologramCommand());
        getCommand("hubcore").setExecutor(new ReloadConfigCommand());
    }

    private void event(Listener... listeners) {
        Arrays.asList(listeners).forEach(eventListener -> Bukkit.getPluginManager().registerEvents(eventListener, this));
    }
    public void papiFAIL(){
        Bukkit.getConsoleSender().sendMessage("PlaceholderAPI isn't found.");
        this.getPluginLoader().disablePlugin(this);
    }
}
