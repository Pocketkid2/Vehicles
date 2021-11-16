package com.github.pocketkid2.vehicles.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.pocketkid2.vehicles.VehiclesPlugin;
import com.github.pocketkid2.vehicles.utils.Messages;

public class CraftBaseCommand implements CommandExecutor {

	private VehiclesPlugin plugin;

	private List<SubCommand> subCommands;

	public CraftBaseCommand(VehiclesPlugin p) {
		plugin = p;
		subCommands = new ArrayList<SubCommand>();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		// Perform permission check first
		if (!sender.hasPermission("vehicles.admin")) {
			sender.sendMessage(Messages.NO_PERMS_MSG);
		}

		// Perform player check since all craft commands can only be done by players
		if (!(sender instanceof Player)) {
			sender.sendMessage(Messages.MUST_BE_PLAYER);
		}
		Player player = (Player) sender;

		// Placeholder code
		sender.sendMessage("Number of command arguments: " + args.length);
		for (int i = 0; i < args.length; i++) {
			sender.sendMessage("Argument " + i + ": " + args[i]);
		}

		return true;
	}

}
