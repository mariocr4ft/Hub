package club.winterlegends.hubcore.config.managers;

import org.bukkit.inventory.ItemStack;

public class GameMode {
    private final String name;
    private final int slot;
    private final ItemStack itemStack;
    private final String command;

    public GameMode(String name, int slot, ItemStack itemStack, String command) {
        this.name = name;
        this.slot = slot;
        this.itemStack = itemStack;
        this.command = command;
    }

    public String name() {
        return this.name;
    }

    public int slot() {
        return this.slot;
    }

    public ItemStack itemStack() {
        return this.itemStack;
    }

    public String command() {
        return this.command;
    }
}
