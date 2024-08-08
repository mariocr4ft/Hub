package club.winterlegends.hubcore.scheduler;

import dev.jcsoftware.jscoreboards.JPerPlayerMethodBasedScoreboard;
import club.winterlegends.hubcore.HubCore;
import club.winterlegends.hubcore.config.managers.Scoreboard;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class UpdateScoreboard extends BukkitRunnable {
    private final JPerPlayerMethodBasedScoreboard scoreboard;

    private final Player target;
    private Scoreboard scoreboardSettings;

    public UpdateScoreboard(Player target) {
        this.scoreboard = HubCore.SCOREBOARD;
        this.scoreboardSettings = HubCore.CONFIG_MANAGER.scoreboard(target);
        this.target = target;
    }

    @Override
    public void run() {
        this.scoreboardSettings = HubCore.CONFIG_MANAGER.scoreboard(target);

        scoreboard.setTitle(target, scoreboardSettings.title());
        scoreboard.setLines(target, scoreboardSettings.content());

        scoreboard.updateScoreboard();
    }
}
