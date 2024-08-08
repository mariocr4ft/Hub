package club.winterlegends.hubcore.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigFile {

    public FileConfiguration file;

    public ConfigFile(Plugin plugin) {
        plugin.saveDefaultConfig();
        file = plugin.getConfig();
    }
}
