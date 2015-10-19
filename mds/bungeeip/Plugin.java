package mds.bungeeip;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;



public class Plugin extends JavaPlugin {
	
	private static Plugin plugin;
	private String bungeeip;
	private String kickMessage;
	
	@Override
	public void onEnable(){
		this.saveDefaultConfig();
		this.reloadConfig();

		getServer().getPluginManager().registerEvents(new PlayerListener(), this);
		
		getCommand("bungeeip").setExecutor(new BungeeCommand());
		
		reload();
	}
	
	private void reload() {
		this.bungeeip = this.getConfig().getString("whitelist-ip", "127.0.0.1");
		this.kickMessage = ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("kick-message", "&4Direct access is not allowed! Please join using the Hub server."));
		
	}
	
	@Override
	public void onDisable(){
		super.onDisable();
	}
	
	public Plugin() {
		plugin = this;
	}
	
	public static Plugin getPlugin() {
		return plugin;
	}
	
	public String getBungeeIP(){
		return bungeeip;
	}
	
	public void setBungeeIP(String ip) {
		this.bungeeip = ip;
		getConfig().set("whitelist-ip", ip);
		saveConfig();
	}
	
	public String getKickMessage() {
		return kickMessage;
	}

}
