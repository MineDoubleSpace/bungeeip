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
	}
	
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
