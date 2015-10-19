package mds.bungeeip;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;



public class Plugin extends JavaPlugin {
	
	private static Plugin plugin;
	private String bungeeip;
	private String kickMessage;
	
	@Override
	public void onEnable(){
		//Save the default config file to disk and reload
		this.saveDefaultConfig();
		this.reloadConfig();

		// Register PlayerLoginEvent event
		getServer().getPluginManager().registerEvents(new PlayerListener(), this);
		
		//Setting bungeeip executor 
		getCommand("bungeeip").setExecutor(new BungeeCommand());
		
		reload();
	}
	
	// Reload method
	public void reload() {
		this.bungeeip = parseIP(this.getConfig().getString("whitelist-ip", "127.0.0.1"));
		this.kickMessage = ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("kick-message", "&4Direct access is not allowed! Please join using the Hub server."));
		
	}
	
	@Override
	public void onDisable(){
		super.onDisable();
	}
	
	public Plugin() {
		plugin = this;
	}
	
	// Returns the plugin
	public static Plugin getPlugin() {
		return plugin;
	}
	
	// Returns BungeeCord IP
	public String getBungeeIP(){
		return bungeeip;
	}
	
	public String parseIP(String ip) {
		if (ip.contains(":")) {
			ip = ip.split(":")[0];
		}
		return ip;
	}
	
	//Sets BungeeIP and save it to config file
	public void setBungeeIP(String ip) {
		this.bungeeip =  parseIP(ip);
		getConfig().set("whitelist-ip", this.bungeeip);
		saveConfig();
	}
	
	public String getKickMessage() {
		return kickMessage;
	}

}
