package cz.nixdevelopment.bcoins.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import cz.nixdevelopment.bcoins.BCoins;

public class OnLeaveListener implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void OnLeaveEvent(PlayerQuitEvent event) {
        
        BCoins.GetPlayers().remove(event.getPlayer().getUniqueId());
        
    }
}
