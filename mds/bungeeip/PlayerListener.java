package mds.bungeeip;

import java.util.logging.Level;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerListener implements Listener {
	
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent event) {
		String ipaddress = event.getRealAddress().getHostAddress();
		if (!ipaddress.equalsIgnoreCase(Plugin.getPlugin().getBungeeIP())) {
			event.setKickMessage(Plugin.getPlugin().getKickMessage());
			event.setResult(PlayerLoginEvent.Result.KICK_WHITELIST);
			Plugin.getPlugin().getLogger().log(Level.INFO, "Player joined using unauthorized IP address (" + ipaddress + "). Kicking player.");
			return;
		}
	}

}
