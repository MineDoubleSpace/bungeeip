package mds.bungeeip;

import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {
	
	private static Plugin plugin;
	private String bungeeip;
	private String kickMessage;
	
	@Override
	public void onEnable(){
		this.saveDefaultConfig();
		this.reloadConfig();
		
		reload();
	}
	
	private void reload() {
		this.bungeeip = this.getConfig().getString("whitelist-ip", "127.0.0.2");
		this.kickMessage = this.getConfig().getString("kick-message", "&4Direct access is not allowed! Please join using the Hub server.");
		
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
	
	public String getKickMessage() {
		return kickMessage;
	}

}
