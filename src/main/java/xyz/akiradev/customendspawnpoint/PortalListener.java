package xyz.akiradev.customendspawnpoint;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PortalListener implements Listener {

    ConfigManager configManager;

    public PortalListener(ConfigManager configManager) {
        this.configManager = configManager;
    }

    @EventHandler
    public void onEnterPortal(PlayerPortalEvent event) {
        if(event.getCause() == PlayerTeleportEvent.TeleportCause.END_PORTAL) {
            event.setTo(configManager.get().getLocation("spawn"));
        }
    }

}
