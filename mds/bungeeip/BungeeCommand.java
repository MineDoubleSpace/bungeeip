package mds.bungeeip;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class BungeeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args) {
		if (sender instanceof Player) {
			if (!sender.hasPermission("bungeeip.setip")) {
				sender.sendMessage(ChatColor.DARK_RED + "No permissions!");
				return false;
			}
		}
		if (args.length < 0) {
			sender.sendMessage(ChatColor.DARK_RED + "Please use /bungeeip <ip address|ip>");
		}
		
		if (args[0].equalsIgnoreCase("ip")) {
			sender.sendMessage(ChatColor.GREEN + "Whitelist-ip: " + Plugin.getPlugin().getBungeeIP());
			return true;
		}
		
		if (args[0].equalsIgnoreCase("reload")) {
			Plugin.getPlugin().reloadConfig();
			Plugin.getPlugin().reload();
			sender.sendMessage(ChatColor.GREEN + "Reloaded config.");
			return true;
		}
		
		Plugin.getPlugin().setBungeeIP(args[0]);
		sender.sendMessage(ChatColor.GREEN + "Updated whitelist IP to " + args[0]);
		return true;
	}

}
