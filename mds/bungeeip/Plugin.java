package mds.bungeeip;

import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {
	
	private static Plugin plugin;
	
	public void onEnable(){
		super.onEnable();
	}
	
	public void onDisable(){
		this.onDisable();
	}
	
	public Plugin() {
		plugin = this;
	}
	
	public static Plugin getPlugin() {
		return plugin;
	}

}
