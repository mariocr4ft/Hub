package club.winterlegends.hubcore.commands;

import club.winterlegends.hubcore.util.holograms.HologramInit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CreateHologramCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (HologramInit.ENABLED) {
            // TODO make the impl asap

            /*
            HologramHandler handler = new HologramHandler();
            Player player = sender.getServer().getPlayer(sender.getName());
            Location loc = player.getLocation();
            Hologram hologram = Hologram.getCachedHologram(HologramHandler.holoID); */
            return true;
        }
        sender.sendMessage("Holograms aren't enabled in the config. Please enable them if you want to use Holograms.");
        return false;
    }
}
