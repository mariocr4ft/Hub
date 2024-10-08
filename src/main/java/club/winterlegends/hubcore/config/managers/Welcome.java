package club.winterlegends.hubcore.config.managers;

import org.bukkit.entity.Player;

import java.util.List;

public class Welcome {
    private final boolean isEnabled, isCentered;
    private final List<String> messageContent;
    private final Player target;

    public Welcome(Boolean isEnabled, Boolean isCentered, List<String> messageContent, Player target) {
        this.isEnabled = isEnabled;
        this.isCentered = isCentered;
        this.messageContent = messageContent;
        this.target = target;

    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public boolean isCentered() {
        return isCentered;
    }

    public List<String> content() {
        return messageContent;
    }
}
