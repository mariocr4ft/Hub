package club.winterlegends.hubcore.config.managers;

import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ServersListItem {
    private final boolean enabled;
    private final ItemStack itemStack;
    private final int slot;
    private final String trigger;
    private final List<String> action;

    public ServersListItem(boolean enabled, ItemStack itemStack, int slot, String trigger, List<String> action) {
        this.itemStack = itemStack;
        this.slot = slot;
        this.trigger = trigger;
        this.action = action;
        this.enabled = enabled;
    }

    public ItemStack itemStack() {
        return this.itemStack;
    }

    public int slot() {
        return this.slot;
    }


    public List<String> action() {
        return this.action;
    }

    public boolean enabled() {
        return this.enabled;
    }
}
